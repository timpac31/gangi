package io.timpac.engine;

import io.timpac.gui.Position;
import io.timpac.piece.Piece;
import io.timpac.piece.PieceAlience;

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
	
	public boolean isBlank() {
		return this.piece == null ? true : false;
	}
	
	public boolean hasMyPiece(PieceAlience pieceAlience) {
		return hasPiece() && pieceAlience == piece.getPieceAlience();
	}
	
	@Override
	public String toString() {
		return "[position]:" + position.getX() + "," + position.getY() + " [piece]:" + (hasPiece() ? piece.name() : "empty");
	}
}
