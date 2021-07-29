package io.timpac.engine.piece;

import io.timpac.gui.Position;

public class King extends Piece {

	public King(Position position, PieceAlience pieceAlience) {
		super(position, pieceAlience);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		return "King";
	}

}
