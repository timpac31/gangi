package io.timpac.piece;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public class Cha extends Piece {
	public Cha(Position position, PieceAlience pieceAlience) {
		super(position, pieceAlience);
		this.pieceType = PieceType.CHA;
	}
	
	@Override
	public boolean validatePieceRule(Tile destinationTile, final Board board) {
		Position destinationPosition = destinationTile.getPosition();
		
		//대각선 움직임 
		if(this.position.getX() != destinationPosition.getX() && this.position.getY() != destinationPosition.getY()) {
			if(this.position.equals(Position.of(4, 1)) || this.position.equals(Position.of(4, 8))) {
				if(destinationPosition.equals(this.position.move(1, 1))) {
					return true;
				}else if(destinationPosition.equals(this.position.move(2, 2)) && board.getTile(this.position.move(1, 1)).isBlank()) {
					return true;
				}
			}
			
			if(this.position.equals(Position.of(6, 1)) || this.position.equals(Position.of(6, 8))) {
				if(destinationPosition.equals(this.position.move(-1, 1))) {
					return true;
				}else if(destinationPosition.equals(this.position.move(-2, 2)) && board.getTile(this.position.move(-1, 1)).isBlank()) {
					return true;
				}
			}
			
			if(this.position.equals(Position.of(5, 2)) || this.position.equals(Position.of(5, 9))) {
				if(destinationPosition.equals(this.position.move(-1, -1)) 
					|| destinationPosition.equals(this.position.move(1, -1))
					|| destinationPosition.equals(this.position.move(-1, 1))
					|| destinationPosition.equals(this.position.move(1, 1))) {
					return true;
				}
			}
			
			if(this.position.equals(Position.of(4, 3)) || this.position.equals(Position.of(4, 10))) {
				if(destinationPosition.equals(this.position.move(1, -1))) {
					return true;
				}else if(destinationPosition.equals(this.position.move(2, -2)) && board.getTile(this.position.move(1, -1)).isBlank()) {
					return true;
				}
			}
			
			if(this.position.equals(Position.of(6, 3)) || this.position.equals(Position.of(6, 10))) {
				if(destinationPosition.equals(this.position.move(-1, -1))) {
					return true;
				}else if(destinationPosition.equals(this.position.move(-2, -2)) && board.getTile(this.position.move(-1, -1)).isBlank()) {
					return true;
				}
			}
				
			return false;
		}
		
		//현재 위치에서 목적지까지 기물이 있는지 체크
		if(this.position.getX() != destinationPosition.getX()) {
			int minX = Math.min(this.position.getX(), destinationPosition.getX());
			int maxX = Math.max(this.position.getX(), destinationPosition.getX());
			if(minX == this.position.getX()) {
				minX += 1;
			}else if(maxX == this.position.getX()) {
				maxX -= 1;
			}
			
			for(int i=minX; i<=maxX; i++) {
				final Tile currentTile = board.getTile(Position.of(i, this.position.getY()));
				if(currentTile.hasPiece()) {
					if(currentTile.getPiece().pieceAlience == this.pieceAlience) {
						return false;
					}else {
						if(destinationPosition.getX() != i) return false;
					}
				}
			}			
		}else if(this.position.getY() != destinationPosition.getY()) {
			int minY = Math.min(this.position.getY(), destinationPosition.getY());
			int maxY = Math.max(this.position.getY(), destinationPosition.getY());
			if(minY == this.position.getY()) {
				minY += 1;
			}else if(maxY == this.position.getY()) {
				maxY -= 1;
			}
			
			for(int i=minY; i<=maxY; i++) {
				final Tile currentTile = board.getTile(Position.of(this.position.getX(), i)); 
				if(currentTile.hasPiece()) {
					if(currentTile.getPiece().pieceAlience == this.pieceAlience) {
						return false;
					}else {
						if(destinationPosition.getY() != i) return false;
					}
				}
			}	
		}

		return true;
	}

	@Override
	public String name() {
		return "Cha";
	}

	
}
