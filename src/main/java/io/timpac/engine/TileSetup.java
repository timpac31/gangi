package io.timpac.engine;

import static io.timpac.piece.PieceAlience.CHO;
import static io.timpac.piece.PieceAlience.HAN;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.timpac.gui.Charim;
import io.timpac.gui.Position;
import io.timpac.piece.Byung;
import io.timpac.piece.Cha;
import io.timpac.piece.King;
import io.timpac.piece.Ma;
import io.timpac.piece.Po;
import io.timpac.piece.Sa;
import io.timpac.piece.Sang;
import io.timpac.util.Uiutils;

public class TileSetup {
	private static final Map<Position, Tile> BASIC_TILES = createBasicTiles();
	
	private static Map<Position, Tile> createBasicTiles() {
		Map<Position, Tile> tiles = new LinkedHashMap<>(Uiutils.TOTAL_TILE_SIZE);
		for(int i=0; i<Uiutils.TOTAL_TILE_SIZE; i++) {
			final Position currentPosition = Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1);
			tiles.put(currentPosition, new Tile(currentPosition)); 
		}
		
		tiles.get(Position.of(1, 1)).setPiece(new Cha(Position.of(1, 1), HAN));
		tiles.get(Position.of(2, 1)).setPiece(new Ma(Position.of(2, 1), HAN));
		tiles.get(Position.of(3, 1)).setPiece(new Sang(Position.of(3, 1), HAN));
		tiles.get(Position.of(4, 1)).setPiece(new Sa(Position.of(4, 1), HAN));
		tiles.get(Position.of(6, 1)).setPiece(new Sa(Position.of(6, 1), HAN));
		tiles.get(Position.of(7, 1)).setPiece(new Sang(Position.of(7, 1), HAN));
		tiles.get(Position.of(8, 1)).setPiece(new Ma(Position.of(8, 1), HAN));
		tiles.get(Position.of(9, 1)).setPiece(new Cha(Position.of(9, 1), HAN));
		tiles.get(Position.of(5, 2)).setPiece(new King(Position.of(5, 2), HAN));
		tiles.get(Position.of(2, 3)).setPiece(new Po(Position.of(2, 3), HAN));
		tiles.get(Position.of(8, 3)).setPiece(new Po(Position.of(8, 3), HAN));
		tiles.get(Position.of(1, 4)).setPiece(new Byung(Position.of(1, 4), HAN));
		tiles.get(Position.of(3, 4)).setPiece(new Byung(Position.of(3, 4), HAN));
		tiles.get(Position.of(5, 4)).setPiece(new Byung(Position.of(5, 4), HAN));
		tiles.get(Position.of(7, 4)).setPiece(new Byung(Position.of(7, 4), HAN));
		tiles.get(Position.of(9, 4)).setPiece(new Byung(Position.of(9, 4), HAN));
		tiles.get(Position.of(1, 10)).setPiece(new Cha(Position.of(1, 10), CHO));
		tiles.get(Position.of(2, 10)).setPiece(new Ma(Position.of(2, 10), CHO));
		tiles.get(Position.of(3, 10)).setPiece(new Sang(Position.of(3, 10), CHO));
		tiles.get(Position.of(4, 10)).setPiece(new Sa(Position.of(4, 10), CHO));
		tiles.get(Position.of(6, 10)).setPiece(new Sa(Position.of(6, 10), CHO));
		tiles.get(Position.of(7, 10)).setPiece(new Sang(Position.of(7, 10), CHO));
		tiles.get(Position.of(8, 10)).setPiece(new Ma(Position.of(8, 10), CHO));
		tiles.get(Position.of(9, 10)).setPiece(new Cha(Position.of(9, 10), CHO));
		tiles.get(Position.of(5, 9)).setPiece(new King(Position.of(5, 9), CHO));
		tiles.get(Position.of(2, 8)).setPiece(new Po(Position.of(2, 8), CHO));
		tiles.get(Position.of(8, 8)).setPiece(new Po(Position.of(8, 8), CHO));
		tiles.get(Position.of(1, 7)).setPiece(new Byung(Position.of(1, 7), CHO));
		tiles.get(Position.of(3, 7)).setPiece(new Byung(Position.of(3, 7), CHO));
		tiles.get(Position.of(5, 7)).setPiece(new Byung(Position.of(5, 7), CHO));
		tiles.get(Position.of(7, 7)).setPiece(new Byung(Position.of(7, 7), CHO));
		tiles.get(Position.of(9, 7)).setPiece(new Byung(Position.of(9, 7), CHO));
		
		return tiles;
	}
	
	public static Map<Position, Tile> getBasicTiles() {
		return new HashMap<>(BASIC_TILES);
	}

	public static Map<Position, Tile> getSettingTiles(Charim choCharim, Charim hanCharim) {
		Map<Position, Tile> tiles = getBasicTiles();
		switch(choCharim) {
			case SMSM:
				tiles.get(Position.of(2, 10)).setPiece(new Sang(Position.of(2, 10), CHO));
				tiles.get(Position.of(3, 10)).setPiece(new Ma(Position.of(3, 10), CHO));
				tiles.get(Position.of(7, 10)).setPiece(new Sang(Position.of(7, 10), CHO));
				tiles.get(Position.of(8, 10)).setPiece(new Ma(Position.of(8, 10), CHO));
				break;
			case SMMS:
				tiles.get(Position.of(2, 10)).setPiece(new Sang(Position.of(2, 10), CHO));
				tiles.get(Position.of(3, 10)).setPiece(new Ma(Position.of(3, 10), CHO));
				tiles.get(Position.of(7, 10)).setPiece(new Ma(Position.of(7, 10), CHO));
				tiles.get(Position.of(8, 10)).setPiece(new Sang(Position.of(8, 10), CHO));
				break;
			case MSMS:
				tiles.get(Position.of(2, 10)).setPiece(new Ma(Position.of(2, 10), CHO));
				tiles.get(Position.of(3, 10)).setPiece(new Sang(Position.of(3, 10), CHO));
				tiles.get(Position.of(7, 10)).setPiece(new Ma(Position.of(7, 10), CHO));
				tiles.get(Position.of(8, 10)).setPiece(new Sang(Position.of(8, 10), CHO));
				break;
			case MSSM:
				tiles.get(Position.of(2, 10)).setPiece(new Ma(Position.of(2, 10), CHO));
				tiles.get(Position.of(3, 10)).setPiece(new Sang(Position.of(3, 10), CHO));
				tiles.get(Position.of(7, 10)).setPiece(new Sang(Position.of(7, 10), CHO));
				tiles.get(Position.of(8, 10)).setPiece(new Ma(Position.of(8, 10), CHO));
				break;
		}
		
		switch(hanCharim) {
			case SMSM:
				tiles.get(Position.of(2, 1)).setPiece(new Sang(Position.of(2, 1), HAN));
				tiles.get(Position.of(3, 1)).setPiece(new Ma(Position.of(3, 1), HAN));
				tiles.get(Position.of(7, 1)).setPiece(new Sang(Position.of(7, 1), HAN));
				tiles.get(Position.of(8, 1)).setPiece(new Ma(Position.of(8, 1), HAN));
				break;
			case SMMS:
				tiles.get(Position.of(2, 1)).setPiece(new Sang(Position.of(2, 1), HAN));
				tiles.get(Position.of(3, 1)).setPiece(new Ma(Position.of(3, 1), HAN));
				tiles.get(Position.of(7, 1)).setPiece(new Ma(Position.of(7, 1), HAN));
				tiles.get(Position.of(8, 1)).setPiece(new Sang(Position.of(8, 1), HAN));
				break;
			case MSMS:
				tiles.get(Position.of(2, 1)).setPiece(new Ma(Position.of(2, 1), HAN));
				tiles.get(Position.of(3, 1)).setPiece(new Sang(Position.of(3, 1), HAN));
				tiles.get(Position.of(7, 1)).setPiece(new Ma(Position.of(7, 1), HAN));
				tiles.get(Position.of(8, 1)).setPiece(new Sang(Position.of(8, 1), HAN));
				break;
			case MSSM:
				tiles.get(Position.of(2, 1)).setPiece(new Ma(Position.of(2, 1), HAN));
				tiles.get(Position.of(3, 1)).setPiece(new Sang(Position.of(3, 1), HAN));
				tiles.get(Position.of(7, 1)).setPiece(new Sang(Position.of(7, 1), HAN));
				tiles.get(Position.of(8, 1)).setPiece(new Ma(Position.of(8, 1), HAN));
				break;
		}
		return tiles;
	}

}
