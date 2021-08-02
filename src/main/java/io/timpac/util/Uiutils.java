package io.timpac.util;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.timpac.engine.piece.Piece;
import io.timpac.gui.Position;

public class Uiutils {
	public static final int TOTAL_TILE_SIZE = 90;
	public static final int TILE_ROW_NUM = 10;
	public static final int TILE_COLUMN_NUM = 9;
	public static final String PIECE_ICON_PATH = "asset/images/";
	
	private static final Map<Position, Integer> POSITION_TO_INDEX = initializePositionToIndex();
	
	public static File getPieceImageFile(Piece piece) {
		return new File(PIECE_ICON_PATH + piece.getPieceAlience().name() + "_" + piece.name() + ".png");
	}
	
	private static Map<Position, Integer> initializePositionToIndex() {
		Map<Position, Integer> result = new HashMap<>();
		
		for(int i=0; i<TOTAL_TILE_SIZE; i++) {
			result.put(Position.of(i % TILE_COLUMN_NUM + 1, i / TILE_COLUMN_NUM + 1), i);
		}
		return Collections.unmodifiableMap(result);
	}
	
	public static int positionToIndex(Position position) {
		return POSITION_TO_INDEX.get(position);
	}
}
