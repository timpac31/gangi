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
	private static final Dimension BOARD_PANEL_SIZE = new Dimension(500, 500);
	private static final Color BACKGROUND_COLOR = Color.decode("#fdcf6f");
	private static final Dimension TILE_PANEL_SIZE = new Dimension(50,50);
	
	private final Board board;
	private Move move;

	BoardPanel(Board board) {
		super(new GridLayout(Uiutils.TILE_ROW_NUM, Uiutils.TILE_COLUMN_NUM));
		this.board = board;
		this.move = new Move(null, null, null);
		
		addTilePanel();
		setPreferredSize(BOARD_PANEL_SIZE);
		validate();
	}
 
	private void addTilePanel() {
		for(int i=0; i<Uiutils.TOTAL_TILE_SIZE; i++) {
			final Position currentPosition = Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1); 
			TilePanel tilePanel = new TilePanel(currentPosition);
			add(tilePanel, i);
		}
	}
	
	private void clearHighlightBorder() {
		Component[] components = getComponents();
		for(int i=0; i<components.length; i++) {
			if(components[i] instanceof TilePanel) {
				TilePanel tilePanel = (TilePanel) components[i];
				if(tilePanel.getComponentCount() > 0) {
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

		TilePanel(Position position) {
			super(new GridBagLayout());
			
			this.position = position;
			
			setPreferredSize(TILE_PANEL_SIZE);
			setBackground(BACKGROUND_COLOR);
			setPiece();
			if(board.getGameStatus() != GameStatus.GAME_OVER) {
				addMouseEvent();
			}
			
			validate();
		}
		
		@Override
		protected void paintBorder(Graphics g) {
			final Dimension d = getSize();
			g.setColor(Color.BLACK);
			g.drawLine(0, d.height/2, d.width, d.height/2);
			g.drawLine(d.width/2, 0, d.width/2, d.height);
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
					}else if(SwingUtilities.isLeftMouseButton(e)) {
						
						if(move.isFirstMove()) {
							Tile clickedtile = board.getTile(position);
							if(clickedtile.hasPiece() && board.getCurrentPlayer() == clickedtile.getPiece().getPieceAlience()) {
								highlightBorder();
								move.setSourceTile(clickedtile);
								move.setMovedPiece(clickedtile.getPiece());
							}else {
								moveAndBoderClear();
							}
						}else {
							move.setDestinationTile(board.getTile(position));
							if(move.getMovedPiece().validate(move.getDestinationTile(), board)) {
								move.getMovedPiece().setPosition(position);
								board.makeMove(move);
							}
							
							moveAndBoderClear();
						}
						
					}// end leftMouseButton
				}
			});
		}
		
		private void highlightBorder() {
			JLabel pieceIcon = (JLabel) getComponent(0);
			pieceIcon.setBorder(BorderFactory.createLineBorder(Color.blue));
		}
		
		
	}

	
}