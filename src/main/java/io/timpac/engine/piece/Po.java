package io.timpac.engine.piece;

import io.timpac.engine.Board;
import io.timpac.engine.Tile;
import io.timpac.gui.Position;

public class Po extends Piece {

	public Po(Position position, PieceAlience pieceAlience) {
		super(position, pieceAlience);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean validate(Tile destinationTile, Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String name() {
		return "Po";
	}

}
