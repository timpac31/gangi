package io.timpac.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import io.timpac.engine.Board;
import io.timpac.engine.Move;
import io.timpac.engine.Tile;
import io.timpac.util.Uiutils;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Dimension BOARD_PANEL_SIZE = new Dimension(500, 500);
	private static final Color BACKGROUND_COLOR = Color.decode("#FFFACD");
	private static final Dimension TILE_PANEL_SIZE = new Dimension(50,50);
	
	private final Board board;
	private Move move;

	BoardPanel(Board board) {
		super(new GridLayout(Uiutils.TILE_ROW_NUM, Uiutils.TILE_COLUMN_NUM));
		this.board = board;
		this.move = new Move(null, null, null);
		
		addTilePanel();
		setPreferredSize(BOARD_PANEL_SIZE);
		setBackground(BACKGROUND_COLOR);
		validate();
	}

	private void addTilePanel() {
		for(int i=0; i<Uiutils.TOTAL_TILE_SIZE; i++) {
			final Position currentPosition = Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1); 
			TilePanel tilePanel = new TilePanel(currentPosition);
			add(tilePanel);
		}
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
			addMouseEvent();
			
			validate();
		}

		@Override
		protected void paintComponent(Graphics g) {
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
						move.clear();
					}else if(SwingUtilities.isLeftMouseButton(e)) {
						
						if(move.isFirstMove()) {
							Tile clickedtile = board.getTile(position);
							if(clickedtile.hasPiece()) {
								move.setSourceTile(clickedtile);
								move.setMovedPiece(clickedtile.getPiece());
							}else {
								move.clear();
							}
						}else {
							move.setDestinationTile(board.getTile(position));
							
							if(move.getMovedPiece().validate(move.getDestinationTile(), board)) {
								// TODO piece position 변경, tilePanel 변경 redraw
								System.out.println("validate 통과");
							}
							
							move.clear();
						}
						
					}// end leftMouseButton
				}
			});
		}
		
	}
	
}