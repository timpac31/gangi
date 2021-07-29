package io.timpac.engine.piece;

import io.timpac.gui.Position;

public abstract class Piece {	
	private Position position;
	private final PieceAlience pieceAlience;
	
	public Piece(Position position, PieceAlience pieceAlience) {
		this.position = position;
		this.pieceAlience = pieceAlience;
	}
	
	public Position getpPosition() {
		return this.position;
	}
	
	public PieceAlience getPieceAlience() {
		return this.pieceAlience;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public abstract String name();
}
