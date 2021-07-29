package io.timpac.engine;

import io.timpac.engine.piece.Piece;
import io.timpac.gui.Position;

public class Tile {
	private final Position position;
	private Piece piece;
	
	public Tile(Position position) {
		this.position = position;
	}

	public Tile(Position position, Piece piece) {
		this.position = position;
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Position getPosition() {
		return position;
	}
	
	public boolean hasPiece() {
		return this.piece == null ? false : true;
	}
}
