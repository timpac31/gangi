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
	public boolean validatePieceRule(Tile destinationTile, final Board board) {
		final Position destinationPosition = destinationTile.getPosition();
		
		if(this.position.getX() != destinationPosition.getX() && this.position.getY() != destinationPosition.getY()) {
			if(this.position.equals(Position.of(4, 1)) || this.position.equals(Position.of(4, 8))) {
				if(destinationPosition.equals(this.position.move(2, 2)) 
					&& board.getTile(this.position.move(1, 1)).hasPiece()
					&& board.getTile(this.position.move(1, 1)).getPiece().getPieceType() != PieceType.PO) {
					return true;
				}
			}
			
			if(this.position.equals(Position.of(6, 1)) || this.position.equals(Position.of(6, 8))) {
				if(destinationPosition.equals(this.position.move(-2, 2)) 
					&& board.getTile(this.position.move(-1, 1)).hasPiece()
					&& board.getTile(this.position.move(-1, 1)).getPiece().getPieceType() != PieceType.PO) {
					return true;
				}
			}
			
			if(this.position.equals(Position.of(4, 3)) || this.position.equals(Position.of(4, 10))) {
				if(destinationPosition.equals(this.position.move(2, -2)) 
					&& board.getTile(this.position.move(1, -1)).hasPiece()
					&& board.getTile(this.position.move(1, -1)).getPiece().getPieceType() != PieceType.PO) {
					return true;
				}
			}
			
			if(this.position.equals(Position.of(6, 3)) || this.position.equals(Position.of(6, 10))) {
				if(destinationPosition.equals(this.position.move(-2, -2)) 
					&& board.getTile(this.position.move(-1, -1)).hasPiece()
					&& board.getTile(this.position.move(-1, -1)).getPiece().getPieceType() != PieceType.PO) {
					return true;
				}
			}
			
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
