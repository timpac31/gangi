package io.timpac.piece;

import java.util.ArrayList;
import java.util.List;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public class Ma extends Piece {

	public Ma(Position position, PieceAlience pieceAlience) {
		super(position, pieceAlience);
		this.pieceType = PieceType.MA;
	}
	
	@Override
	public boolean validatePieceRule(Tile destinationTile, final Board board) {
		return getAllMovePosition(board).contains(destinationTile.getPosition());
	}
	
	private List<Position> getAllMovePosition(Board board) {
		List<Position> result = new ArrayList<>();
		
		if(board.getTile(this.position.move(1, 0)).isBlank()) {
			result.add(this.position.move(2, 1));
			result.add(this.position.move(2, -1));
		}
		if(board.getTile(this.position.move(-1, 0)).isBlank()) {
			result.add(this.position.move(-2, 1));
			result.add(this.position.move(-2, -1));
		}
		if(board.getTile(this.position.move(0, -1)).isBlank()) {
			result.add(this.position.move(-1, -2));
			result.add(this.position.move(1, -2));
		}
		if(board.getTile(this.position.move(0, 1)).isBlank()) {
			result.add(this.position.move(-1, 2));
			result.add(this.position.move(1, 2));
		}
		
		return result;
	}

	@Override
	public String name() {
		return "Ma";
	}

}
