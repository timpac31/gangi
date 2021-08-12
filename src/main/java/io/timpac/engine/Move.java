package io.timpac.engine;

import io.timpac.piece.Piece;

public class Move {
	private Tile sourceTile;
	private Tile destinationTile;
	private Piece movedPiece;
	private Piece targetPiece;
	
	public final static Move EMPTY_MOVE = new Move(null, null, null, null);
	
	public Move(Tile sourceTile, Tile destinationTile, Piece movedPiece, Piece targetPiece) {
		this.sourceTile = sourceTile;
		this.destinationTile = destinationTile;
		this.movedPiece = movedPiece;
		this.targetPiece = targetPiece;
	}
	
	public static Move newInstance(Move move) {
		return new Move(move.getSourceTile(), move.getDestinationTile(), move.getMovedPiece(), move.getTargetPiece());
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
	
	public Piece getTargetPiece() {
		return targetPiece;
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
	
	public void setTargetPiece(Piece targetPiece) {
		this.targetPiece = targetPiece;
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
