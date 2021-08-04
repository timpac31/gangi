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
	
	public boolean validate(Tile destinationTile, Board board) {
		if(isMyAlienceOccupied(destinationTile)) {
			return false;
		}
		
		return validatePieceRule(destinationTile, board);
	}
	
	private boolean isMyAlienceOccupied(Tile destinationTile) {
		return destinationTile.hasPiece() && destinationTile.getPiece().getPieceAlience() == this.pieceAlience;
	}
			
	public abstract String name();
	public abstract boolean validatePieceRule(Tile destinationTile, Board board);
}
