package io.timpac.piece;

import java.util.ArrayList;
import java.util.List;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public class King extends Piece {

	public King(Position position, PieceAlience pieceAlience) {
		super(position, pieceAlience);
		this.pieceType = PieceType.KING;
	}

	@Override
	public boolean validatePieceRule(Tile destinationTile, final Board board) {
		return getAllMovePosition().contains(destinationTile.getPosition()); 
	}
	
	private List<Position> getAllMovePosition() {
		List<Position> result = new ArrayList<>();
		
		if(this.position.equals(Position.of(4, 1)) || this.position.equals(Position.of(4, 8))) {
			result.add(this.position.move(1,0));
			result.add(this.position.move(0,1));
			result.add(this.position.move(1,1));
		}else if(this.position.equals(Position.of(5, 1)) || this.position.equals(Position.of(5, 8))) {
			result.add(this.position.move(-1, 0));
			result.add(this.position.move(0, 1));
			result.add(this.position.move(1, 0));
		}else if(this.position.equals(Position.of(6, 1)) || this.position.equals(Position.of(6, 8))) {
			result.add(this.position.move(-1, 0));
			result.add(this.position.move(0, 1));
			result.add(this.position.move(-1, 1));
		}else if(this.position.equals(Position.of(4, 2)) || this.position.equals(Position.of(4, 9))) {
			result.add(this.position.move(1, 0));
			result.add(this.position.move(0, -1));
			result.add(this.position.move(0, 1));
		}else if(this.position.equals(Position.of(5, 2)) || this.position.equals(Position.of(5, 9))) {
			result.add(this.position.move(-1, 0));
			result.add(this.position.move(1, 0));
			result.add(this.position.move(0, -1));
			result.add(this.position.move(0, 1));
			result.add(this.position.move(-1, -1));
			result.add(this.position.move(-1, 1));
			result.add(this.position.move(1, -1));
			result.add(this.position.move(1, 1));
		}else if(this.position.equals(Position.of(6, 2)) || this.position.equals(Position.of(6, 9))) {
			result.add(this.position.move(-1, 0));
			result.add(this.position.move(0, 1));
			result.add(this.position.move(0, -1));
		}else if(this.position.equals(Position.of(4, 3)) || this.position.equals(Position.of(4, 10))) {
			result.add(this.position.move(0, -1));
			result.add(this.position.move(1, 0));
			result.add(this.position.move(1, -1));
		}else if(this.position.equals(Position.of(5, 3)) || this.position.equals(Position.of(5, 10))) {
			result.add(this.position.move(-1, 0));
			result.add(this.position.move(0, -1));
			result.add(this.position.move(1, 0));
		}else if(this.position.equals(Position.of(6, 3)) || this.position.equals(Position.of(6, 10))) {
			result.add(this.position.move(-1, -1));
			result.add(this.position.move(0, -1));
			result.add(this.position.move(-1, 0));
		}
		
		return result;
	}
	
	@Override
	public String name() {
		return "King";
	}

}
