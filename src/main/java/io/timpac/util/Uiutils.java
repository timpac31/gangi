package io.timpac.util;

import java.io.File;

import io.timpac.engine.piece.Piece;

public class Uiutils {
	public static final int TOTAL_TILE_SIZE = 90;
	public static final int TILE_ROW_NUM = 10;
	public static final int TILE_COLUMN_NUM = 9;
	public static final String PIECE_ICON_PATH = "asset/images/";
	
	public static File getPieceImageFile(Piece piece) {
		return new File(PIECE_ICON_PATH + piece.getPieceAlience().name() + "_" + piece.name() + ".png");
	}
}
