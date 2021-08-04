package io.timpac.engine;

import io.timpac.piece.Piece;

public class Move {
	private Tile sourceTile;
	private Tile destinationTile;
	private Piece movedPiece;
	
	public final static Move EMPTY_MOVE = new Move(null, null, null);
	
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
	
	public void setSourceTile(Tile sourceTile) {
		this.sourceTile = sourceTile;
	}

	public void setDestinationTile(Tile destinationTile) {
		this.destinationTile = destinationTile;
	}

	public void setMovedPiece(Piece movedPiece) {
		this.movedPiece = movedPiece;
	}

	public boolean isFirstMove() {
		return this.sourceTile == null;
	}
	
	public void clear() {
		this.sourceTile = null;
		this.destinationTile = null;
		this.movedPiece = null;
	}
}
