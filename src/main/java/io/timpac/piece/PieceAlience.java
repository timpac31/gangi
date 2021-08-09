package io.timpac.piece;

public enum PieceAlience {
	CHO("초") {
		public PieceAlience opponentPlayer() {
			return HAN;
		}
		
		public int getDisplayRow() {
			return 2;
		}
	},
	HAN("한") {
		public PieceAlience opponentPlayer() {
			return CHO;
		}
		
		public int getDisplayRow() {
			return 0;
		}
	};
	
	private String title;

	private PieceAlience(String title) {
		this.title = title;
	}
	
	public String title() {
		return this.title;
	}
	
	abstract public PieceAlience opponentPlayer();
	abstract public int getDisplayRow();
}
