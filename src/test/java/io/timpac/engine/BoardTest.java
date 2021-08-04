package io.timpac.engine;

import java.util.Map;

import org.junit.jupiter.api.Test;

import io.timpac.gui.Position;
import io.timpac.piece.Piece;
import io.timpac.util.Uiutils;

public class BoardTest {
	@Test
	public void boardPrint() {
		Board board = new Board();
		Map<Position, Tile> tiles = board.getTiles();
		
		StringBuilder sb = new StringBuilder();
				
		for(int i=0; i<tiles.size(); i++) {
			Piece curPiece = tiles.get(Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1)).getPiece();
			sb.append(String.format("%2s", curPiece == null ? "-" : curPiece.name().substring(0,1) ));
			
			if((i+1) % Uiutils.TILE_COLUMN_NUM == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
