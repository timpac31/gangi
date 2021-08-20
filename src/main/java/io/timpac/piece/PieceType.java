package io.timpac.piece;

public enum PieceType {
	KING("궁", 0),	
	CHA("차", 13),	
	PO("포", 7),
	MA("마", 5),
	SANG("상", 3),
	SA("사", 3),
	BYUNG("병", 2);
	
	private String pieceName;
	private int score;
	
	private PieceType(String pieceName, int score) {
		this.pieceName = pieceName;
		this.score = score;
	}

	public String pieceName() {
		return pieceName;
	}

	public int score() {
		return score;
	}
}
