package io.timpac.engine.piece;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public abstract class Piece {	
	protected Position position;
	protected final PieceAlience pieceAlience;
	
	public Piece(Position position, PieceAlience pieceAlience) {
		this.position = position;
		this.pieceAlience = pieceAlience;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public PieceAlience getPieceAlience() {
		return this.pieceAlience;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
			
	public abstract String name();
	public abstract boolean validate(Tile destinationTile, Board board);
}
