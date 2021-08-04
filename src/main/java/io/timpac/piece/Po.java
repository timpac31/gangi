package io.timpac.piece;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public class Po extends Piece {
	public Po(Position position, PieceAlience pieceAlience) {
		super(position, pieceAlience);
		this.pieceType = PieceType.PO;
	}
	
	@Override
	public boolean validatePieceRule(Tile destinationTile, Board board) {
		final Position destinationPosition = destinationTile.getPosition();
		
		if(this.position.getX() != destinationPosition.getX() && this.position.getY() != destinationPosition.getY()) {
			return false;
		}
		
		if(destinationTile.hasPiece() && destinationTile.getPiece().getPieceType() == PieceType.PO) {
			return false;
		}
		
		int min;
		int max;
		int innerPieceCount = 0;
		
		if(this.position.getX() != destinationPosition.getX()) {
			min = Math.min(this.position.getX(), destinationPosition.getX()) + 1;
			max = Math.max(this.position.getX(), destinationPosition.getX());
			
			for(int i=min; i<max; i++) {
				final Tile currentTile = board.getTile(Position.of(i, destinationPosition.getY()));
				
				if(currentTile.hasPiece() && currentTile.getPiece().getPieceType() == PieceType.PO) {
					return false;
				}
				
				if(currentTile.hasPiece()) {
					innerPieceCount++;
				}
			}
		}else if(this.position.getY() != destinationPosition.getY()) {
			min = Math.min(this.position.getY(), destinationPosition.getY()) + 1;
			max = Math.max(this.position.getY(), destinationPosition.getY());
			
			for(int i=min; i<max; i++) {
				final Tile currentTile = board.getTile(Position.of(destinationPosition.getX(), i));
				
				if(currentTile.hasPiece() && currentTile.getPiece().getPieceType() == PieceType.PO) {
					return false;
				}
				
				if(currentTile.hasPiece()) {
					innerPieceCount++;
				}
			}
		}
		
		return innerPieceCount == 1;
	}

	@Override
	public String name() {
		return "Po";
	}

}
