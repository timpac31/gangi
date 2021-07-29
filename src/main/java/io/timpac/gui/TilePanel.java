package io.timpac.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
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

public class TilePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Color BACKGROUND_COLOR = Color.decode("#FFFACD");
	private static final Dimension TILE_PANEL_SIZE = new Dimension(50,50);
	
	private final Position position;
	private final Board board;
	private Move move;

	TilePanel(Position position, Board board) {
		super(new GridBagLayout());
		
		this.position = position;
		this.board = board;
		
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
					//TODO empty null static
					move = new Move(null, null, null);
				}else if(SwingUtilities.isLeftMouseButton(e)) {
					
					if(move.isFirstMove()) {
						Tile clickedtile = board.getTile(position);
						if(clickedtile.hasPiece()) {
							move = new Move(clickedtile, null, clickedtile.getPiece());
						}else {
							move = new Move(null, null, null);
						}
					}else {
						//TODO 움직임 검증 -> 움직임 가능하면 board, tile, piece position 변경, tilePanel 변경 redraw 
						//List<Move> legalMoves = board.getMovableDestination(move);
						
						
						move = new Move(null, null, null);
					}
					
				}// end leftMouseButton
			}
		});
	}
	
	public Position getPosition() {
		return this.position;
	}
}
