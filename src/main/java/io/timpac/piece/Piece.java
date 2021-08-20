package io.timpac.piece;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public abstract class Piece {	
	protected Position position;
	protected final PieceAlience pieceAlience;
	protected PieceType pieceType;
	
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
	
	public PieceType getPieceType() {
		return this.pieceType;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public boolean validate(Tile destinationTile, final Board board) {
		if(destinationTile.hasMyPiece(this.pieceAlience)) {
			return false;
		}
		
		return validatePieceRule(destinationTile, board);
	}
			
	public abstract String name();
	public abstract boolean validatePieceRule(Tile destinationTile, Board board);
	
	@Override
	public String toString() {
		return this.pieceAlience.title() + " " + this.pieceType.pieceName();
	}
}
