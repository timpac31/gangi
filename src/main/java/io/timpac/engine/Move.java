package io.timpac.engine;

import io.timpac.engine.piece.Piece;

public class Move {
	private final Tile sourceTile;
	private final Tile destinationTile;
	private final Piece movedPiece;
	
	public Move(Tile sourceTile, Tile destinationTile, Piece movedPiece) {
		this.sourceTile = sourceTile;
		this.destinationTile = destinationTile;
		this.movedPiece = movedPiece;
	}

	public Tile getSourceTile() {
		return sourceTile;
	}

	public Tile getDestinationTile() {
		return destinationTile;
	}

	public Piece getMovedPiece() {
		return movedPiece;
	}
	
	public boolean isFirstMove() {
		return this.sourceTile == null;
	}
}
