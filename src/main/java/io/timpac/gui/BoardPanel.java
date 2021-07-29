package io.timpac.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import io.timpac.engine.Board;
import io.timpac.util.Uiutils;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Dimension BOARD_PANEL_SIZE = new Dimension(500, 500);

	BoardPanel(Board board) {
		super(new GridLayout(Uiutils.TILE_ROW_NUM, Uiutils.TILE_COLUMN_NUM));
		addTilePanel(board);
		setPreferredSize(BOARD_PANEL_SIZE);
		validate();
	}

	private void addTilePanel(Board board) {
		for(int i=0; i<Uiutils.TOTAL_TILE_SIZE; i++) {
			final Position currentPosition = Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1); 
			TilePanel tilePanel = new TilePanel(currentPosition, board);
			add(tilePanel);
		}
	}
	
}