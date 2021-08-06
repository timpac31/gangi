package io.timpac.piece;

public enum PieceAlience {
	CHO {
		public PieceAlience opponentPlayer() {
			return HAN;
		}
		
		public int getDisplayRow() {
			return 1;
		}
	},
	HAN {
		public PieceAlience opponentPlayer() {
			return CHO;
		}
		
		public int getDisplayRow() {
			return 0;
		}
	};

	abstract public PieceAlience opponentPlayer();
	abstract public int getDisplayRow();
}
