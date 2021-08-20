package io.timpac.piece;

import java.util.ArrayList;
import java.util.List;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public class Byung extends Piece {
	public Byung(Position position, PieceAlience pieceAlience) {
		super(position, pieceAlience);
		this.pieceType = PieceType.BYUNG;
	}
	
	@Override
	public boolean validatePieceRule(final Tile destinationTile, final Board board) {
		return getAllMovePosition().contains(destinationTile.getPosition());
	}
	
	private List<Position> getAllMovePosition() {
		List<Position> result = new ArrayList<>();
		
		if(this.pieceAlience == PieceAlience.CHO) {
			result.add(this.position.move(1, 0));
			result.add(this.position.move(-1, 0));
			result.add(this.position.move(0, -1));
		}else if(this.pieceAlience == PieceAlience.HAN) {
			result.add(this.position.move(1, 0));
			result.add(this.position.move(-1, 0));
			result.add(this.position.move(0, 1));
		}
		
		return result;
	}
	
	@Override
	public String name() {
		return "Byung";
	}
}
