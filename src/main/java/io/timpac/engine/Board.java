package io.timpac.engine;

import java.util.HashMap;
import java.util.Map;

import io.timpac.engine.piece.Byung;
import io.timpac.engine.piece.Cha;
import io.timpac.engine.piece.King;
import io.timpac.engine.piece.Ma;
import io.timpac.engine.piece.PieceAlience;
import io.timpac.engine.piece.Po;
import io.timpac.engine.piece.Sa;
import io.timpac.engine.piece.Sang;
import io.timpac.gui.Position;
import io.timpac.util.Uiutils;

public class Board {
	private final Map<Position, Tile> tiles = new HashMap<>(Uiutils.TOTAL_TILE_SIZE);
	
	public Board() {
		createEmptyTiles();
		setPieceAtTile();
	}
	
	private void createEmptyTiles() {
		for(int i=0; i<Uiutils.TOTAL_TILE_SIZE; i++) {
			final Position currentPosition = Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1);
			tiles.put(currentPosition, new Tile(currentPosition)); 
		}
	}
	
	private void setPieceAtTile() {
		this.tiles.get(Position.of(1, 1)).setPiece(new Cha(Position.of(1, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(2, 1)).setPiece(new Ma(Position.of(2, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(3, 1)).setPiece(new Sang(Position.of(3, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(4, 1)).setPiece(new Sa(Position.of(4, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(6, 1)).setPiece(new Sa(Position.of(6, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(7, 1)).setPiece(new Sang(Position.of(7, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(8, 1)).setPiece(new Ma(Position.of(8, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(9, 1)).setPiece(new Cha(Position.of(9, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(5, 2)).setPiece(new King(Position.of(5, 2), PieceAlience.HAN));
		this.tiles.get(Position.of(2, 3)).setPiece(new Po(Position.of(2, 3), PieceAlience.HAN));
		this.tiles.get(Position.of(8, 3)).setPiece(new Po(Position.of(8, 3), PieceAlience.HAN));
		this.tiles.get(Position.of(1, 4)).setPiece(new Byung(Position.of(1, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(3, 4)).setPiece(new Byung(Position.of(3, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(5, 4)).setPiece(new Byung(Position.of(5, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(7, 4)).setPiece(new Byung(Position.of(7, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(9, 4)).setPiece(new Byung(Position.of(9, 4), PieceAlience.HAN));
		
		this.tiles.get(Position.of(1, 10)).setPiece(new Cha(Position.of(1, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(2, 10)).setPiece(new Ma(Position.of(2, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(3, 10)).setPiece(new Sang(Position.of(3, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(4, 10)).setPiece(new Sa(Position.of(4, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(6, 10)).setPiece(new Sa(Position.of(6, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(7, 10)).setPiece(new Sang(Position.of(7, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(8, 10)).setPiece(new Ma(Position.of(8, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(9, 10)).setPiece(new Cha(Position.of(9, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(5, 9)).setPiece(new King(Position.of(5, 9), PieceAlience.CHO));
		this.tiles.get(Position.of(2, 8)).setPiece(new Po(Position.of(2, 8), PieceAlience.CHO));
		this.tiles.get(Position.of(8, 8)).setPiece(new Po(Position.of(8, 8), PieceAlience.CHO));
		this.tiles.get(Position.of(1, 7)).setPiece(new Byung(Position.of(1, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(3, 7)).setPiece(new Byung(Position.of(3, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(5, 7)).setPiece(new Byung(Position.of(5, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(7, 7)).setPiece(new Byung(Position.of(7, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(9, 7)).setPiece(new Byung(Position.of(9, 7), PieceAlience.CHO));
	}
	
	public Tile getTile(Position position) {
		return this.tiles.get(position);
	}
}
