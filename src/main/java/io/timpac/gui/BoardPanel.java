package io.timpac.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import io.timpac.engine.Board;
import io.timpac.engine.GameStatus;
import io.timpac.engine.Move;
import io.timpac.engine.Tile;
import io.timpac.util.Uiutils;

public class BoardPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private static final Dimension BOARD_PANEL_SIZE = new Dimension(450, 500);
	private static final Color BACKGROUND_COLOR = Color.decode("#fdcf6f");
	private static final Dimension TILE_PANEL_SIZE = new Dimension(50,50);
	
	private final Board board;
	private Move move;

	BoardPanel(Board board) {
		super(new GridLayout(Uiutils.TILE_ROW_NUM, Uiutils.TILE_COLUMN_NUM));
		this.board = board;
		this.move = new Move(null, null, null, null);
		
		addTilePanel();
		setPreferredSize(BOARD_PANEL_SIZE);
		validate();
	}
 
	private void addTilePanel() {
		for(int i=0; i<Uiutils.TOTAL_TILE_SIZE; i++) {
			final Position currentPosition = Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1);
			TilePanel tilePanel = new TilePanel(
					currentPosition, 
					move.getDestinationTile() != null && move.getDestinationTile().getPosition().equals(currentPosition));
			add(tilePanel, i);
		}
	}
	
	private void clearHighlightBorder() {
		Component[] components = getComponents();
		for(int i=0; i<components.length; i++) {
			if(components[i] instanceof TilePanel) {
				TilePanel tilePanel = (TilePanel) components[i];
				if(tilePanel.getComponentCount() > 0 && !tilePanel.isDestination) {
					JLabel pieceIcon = (JLabel) tilePanel.getComponent(0);
					pieceIcon.setBorder(BorderFactory.createEmptyBorder());
				}
			}
		}
	}
	
	private void moveAndBoderClear() {
		move.clear();
		clearHighlightBorder();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//Notify by Board.makeMove()
		tileUpdate();
		
		if(board.getGameStatus() == GameStatus.GAME_OVER) {
			JOptionPane.showMessageDialog(this, board.getCurrentPlayer().opponentPlayer().title() + " 승리!!");
		}
	}
	
	private void tileUpdate() {
		removeAll();
		addTilePanel();
		validate();
		repaint();
	}
	
	
	
	/** Tile Panel inner class */
	private class TilePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private final Position position;
		private final boolean isDestination;

		TilePanel(Position position, boolean isDestination) {
			super(new GridBagLayout());
			
			this.position = position;
			this.isDestination = isDestination;
			
			setPreferredSize(TILE_PANEL_SIZE);
			setBackground(BACKGROUND_COLOR);
			setPiece();
			if(board.getGameStatus() != GameStatus.GAME_OVER) {
				addMouseEvent();
			}
			if(isDestination) {
				highlightBorder();
			}
			validate();
		}
		
		@Override
		protected void paintBorder(Graphics g) {
			final Dimension d = getSize();
			g.setColor(Color.BLACK);
			
			//가운데 라인
			g.drawLine(0, d.height/2, d.width, d.height/2);
			g.drawLine(d.width/2, 0, d.width/2, d.height);
			
			//궁성 대각선
			int x = this.position.getX();
			int y = this.position.getY();
			if(x == 4 && (y == 1 || y == 8)) {
				g.drawLine(d.width/2, d.height/2, d.width, d.height);
			}else if(x == 4 && (y == 3 || y == 10)) {
				g.drawLine(d.width/2, d.height/2, d.width, 0);
			}else if(x == 5 && (y == 2 || y == 9)) {
				g.drawLine(0, 0, d.width, d.height);
				g.drawLine(0, d.height, d.width, 0);
			}else if(x == 6 && (y == 3 || y == 10)) {
				g.drawLine(0, 0, d.width/2, d.height/2);
			}else if(x == 6 && (y == 1 || y == 8)) {
				g.drawLine(0, d.height, d.width/2, d.height/2);
			}
			
			//모서리 라인 삭제
			g.setColor(BACKGROUND_COLOR);
			if(x == 1) {
				g.fillRect(0, 0, d.width/2, d.height);
			}else if(x == 9) {
				g.fillRect(d.width/2 + 1, 0, d.width/2, d.height);
			}
			if(y == 1) {
				g.fillRect(0, 0, d.width, d.height/2);
			}else if(y == 10) {
				g.fillRect(0, d.height/2 + 1, d.width, d.height/2);
			}
		}
		
		private void setPiece() {
			if(board.getTile(this.position).hasPiece()) {
				try {
					File iconFile = Uiutils.getPieceImageFile(board.getTile(this.position).getPiece());
					BufferedImage image = ImageIO.read(iconFile);
					add(new JLabel(new ImageIcon(image)));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void addMouseEvent() {
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(SwingUtilities.isRightMouseButton(e)) {
						moveAndBoderClear();
						return;
					}
						
					Tile clickedtile = board.getTile(position);
					if(move.isFirstMove()) {
						if(clickedtile.hasMyPiece(board.getCurrentPlayer())) {
							highlightBorder();
							move.setSourceTile(clickedtile);
							move.setMovedPiece(clickedtile.getPiece());
						}else {
							moveAndBoderClear();
						}
					}else {
						move.setDestinationTile(clickedtile);
						if(move.getMovedPiece().validate(move.getDestinationTile(), board)) {
							move.getMovedPiece().setPosition(position);
							move.setTargetPiece(clickedtile.getPiece());
							board.makeMove(move);
							move.clear();
						}else if(board.hasMyPiece(position)) {
							moveAndBoderClear();
							highlightBorder();
							move.setSourceTile(clickedtile);
							move.setMovedPiece(clickedtile.getPiece());
						}else {
							moveAndBoderClear();
						}
					}
				}
			});
		}
		
		private void highlightBorder() {
			JLabel pieceIcon = (JLabel) getComponent(0);
			pieceIcon.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
		
	}

	
}