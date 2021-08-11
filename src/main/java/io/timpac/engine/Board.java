package io.timpac.engine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;

import io.timpac.gui.Charim;
import io.timpac.gui.Position;
import io.timpac.piece.Byung;
import io.timpac.piece.Cha;
import io.timpac.piece.King;
import io.timpac.piece.Ma;
import io.timpac.piece.Piece;
import io.timpac.piece.PieceAlience;
import io.timpac.piece.PieceType;
import io.timpac.piece.Po;
import io.timpac.piece.Sa;
import io.timpac.piece.Sang;
import io.timpac.util.Uiutils;

public class Board extends Observable {
	private final Map<Position, Tile> tiles = new LinkedHashMap<>(Uiutils.TOTAL_TILE_SIZE);
	private PieceAlience currentPlayer;
	private GameStatus gameStatus;
	
	public Board() {
		initialize();
	}
	
	public void initialize() {
		createEmptyTiles();
		setPieceAtTile();
		this.currentPlayer = PieceAlience.CHO;
		this.gameStatus = GameStatus.READY;
	}
	
	private void createEmptyTiles() {
		for(int i=0; i<Uiutils.TOTAL_TILE_SIZE; i++) {
			final Position currentPosition = Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1);
			tiles.put(currentPosition, new Tile(currentPosition)); 
		}
	}
	
	private void setPieceAtTile() {
		this.tiles.get(Position.of(1, 1)).setPiece(new Cha(Position.of(1, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(2, 1)).setPiece(new Ma(Position.of(2, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(3, 1)).setPiece(new Sang(Position.of(3, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(4, 1)).setPiece(new Sa(Position.of(4, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(6, 1)).setPiece(new Sa(Position.of(6, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(7, 1)).setPiece(new Sang(Position.of(7, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(8, 1)).setPiece(new Ma(Position.of(8, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(9, 1)).setPiece(new Cha(Position.of(9, 1), PieceAlience.HAN));
		this.tiles.get(Position.of(5, 2)).setPiece(new King(Position.of(5, 2), PieceAlience.HAN));
		this.tiles.get(Position.of(2, 3)).setPiece(new Po(Position.of(2, 3), PieceAlience.HAN));
		this.tiles.get(Position.of(8, 3)).setPiece(new Po(Position.of(8, 3), PieceAlience.HAN));
		this.tiles.get(Position.of(1, 4)).setPiece(new Byung(Position.of(1, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(3, 4)).setPiece(new Byung(Position.of(3, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(5, 4)).setPiece(new Byung(Position.of(5, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(7, 4)).setPiece(new Byung(Position.of(7, 4), PieceAlience.HAN));
		this.tiles.get(Position.of(9, 4)).setPiece(new Byung(Position.of(9, 4), PieceAlience.HAN));
		
		this.tiles.get(Position.of(1, 10)).setPiece(new Cha(Position.of(1, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(2, 10)).setPiece(new Ma(Position.of(2, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(3, 10)).setPiece(new Sang(Position.of(3, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(4, 10)).setPiece(new Sa(Position.of(4, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(6, 10)).setPiece(new Sa(Position.of(6, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(7, 10)).setPiece(new Sang(Position.of(7, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(8, 10)).setPiece(new Ma(Position.of(8, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(9, 10)).setPiece(new Cha(Position.of(9, 10), PieceAlience.CHO));
		this.tiles.get(Position.of(5, 9)).setPiece(new King(Position.of(5, 9), PieceAlience.CHO));
		this.tiles.get(Position.of(2, 8)).setPiece(new Po(Position.of(2, 8), PieceAlience.CHO));
		this.tiles.get(Position.of(8, 8)).setPiece(new Po(Position.of(8, 8), PieceAlience.CHO));
		this.tiles.get(Position.of(1, 7)).setPiece(new Byung(Position.of(1, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(3, 7)).setPiece(new Byung(Position.of(3, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(5, 7)).setPiece(new Byung(Position.of(5, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(7, 7)).setPiece(new Byung(Position.of(7, 7), PieceAlience.CHO));
		this.tiles.get(Position.of(9, 7)).setPiece(new Byung(Position.of(9, 7), PieceAlience.CHO));
	}
	
	public void tableSetting(Charim choCharim, Charim hanCharim) {
		switch(choCharim) {
			case SMSM:
				this.tiles.get(Position.of(2, 10)).setPiece(new Sang(Position.of(2, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(3, 10)).setPiece(new Ma(Position.of(3, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(7, 10)).setPiece(new Sang(Position.of(7, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(8, 10)).setPiece(new Ma(Position.of(8, 10), PieceAlience.CHO));
				break;
			case SMMS:
				this.tiles.get(Position.of(2, 10)).setPiece(new Sang(Position.of(2, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(3, 10)).setPiece(new Ma(Position.of(3, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(7, 10)).setPiece(new Ma(Position.of(7, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(8, 10)).setPiece(new Sang(Position.of(8, 10), PieceAlience.CHO));
				break;
			case MSMS:
				this.tiles.get(Position.of(2, 10)).setPiece(new Ma(Position.of(2, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(3, 10)).setPiece(new Sang(Position.of(3, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(7, 10)).setPiece(new Ma(Position.of(7, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(8, 10)).setPiece(new Sang(Position.of(8, 10), PieceAlience.CHO));
				break;
			case MSSM:
				this.tiles.get(Position.of(2, 10)).setPiece(new Ma(Position.of(2, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(3, 10)).setPiece(new Sang(Position.of(3, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(7, 10)).setPiece(new Sang(Position.of(7, 10), PieceAlience.CHO));
				this.tiles.get(Position.of(8, 10)).setPiece(new Ma(Position.of(8, 10), PieceAlience.CHO));
				break;
		}
		
		switch(hanCharim) {
			case SMSM:
				this.tiles.get(Position.of(2, 1)).setPiece(new Sang(Position.of(2, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(3, 1)).setPiece(new Ma(Position.of(3, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(7, 1)).setPiece(new Sang(Position.of(7, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(8, 1)).setPiece(new Ma(Position.of(8, 1), PieceAlience.HAN));
				break;
			case SMMS:
				this.tiles.get(Position.of(2, 1)).setPiece(new Sang(Position.of(2, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(3, 1)).setPiece(new Ma(Position.of(3, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(7, 1)).setPiece(new Ma(Position.of(7, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(8, 1)).setPiece(new Sang(Position.of(8, 1), PieceAlience.HAN));
				break;
			case MSMS:
				this.tiles.get(Position.of(2, 1)).setPiece(new Ma(Position.of(2, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(3, 1)).setPiece(new Sang(Position.of(3, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(7, 1)).setPiece(new Ma(Position.of(7, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(8, 1)).setPiece(new Sang(Position.of(8, 1), PieceAlience.HAN));
				break;
			case MSSM:
				this.tiles.get(Position.of(2, 1)).setPiece(new Ma(Position.of(2, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(3, 1)).setPiece(new Sang(Position.of(3, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(7, 1)).setPiece(new Sang(Position.of(7, 1), PieceAlience.HAN));
				this.tiles.get(Position.of(8, 1)).setPiece(new Ma(Position.of(8, 1), PieceAlience.HAN));
				break;
		}
	}
	
	public void makeMove(Move move) {
		if(isGameOver(move.getDestinationTile())) {
			this.gameStatus = GameStatus.GAME_OVER;
		}else if(this.gameStatus != GameStatus.START) {
			this.gameStatus = GameStatus.START;
		}
		
		getTile(move.getDestinationTile().getPosition()).setPiece(move.getMovedPiece());
		getTile(move.getSourceTile().getPosition()).setPiece(null);
		this.currentPlayer = this.currentPlayer.opponentPlayer();
		
		setChanged();
		notifyObservers();
	}
	
	private boolean isGameOver(Tile destinationTile) {
		return destinationTile.hasPiece() 
				&& destinationTile.getPiece().getPieceAlience() != this.currentPlayer 
				&& destinationTile.getPiece().getPieceType() == PieceType.KING;
	}
	
	public float calculateTotalScore(PieceAlience pieceAlience) {
		float result = 0f;
		for(Tile tile : this.tiles.values()) {
			if(tile.hasPiece() && tile.getPiece().getPieceAlience() == pieceAlience) {
				result += tile.getPiece().getPieceType().score();
			}
		}
		
		return result + (pieceAlience == PieceAlience.HAN ? 1.5f : 0f);
	}
	
	public boolean hasMyPiece(Position position) {
		Tile tile = getTile(position);
		return tile.hasPiece() && tile.getPiece().getPieceAlience() == this.currentPlayer; 
	}
	
	public Tile getTile(Position position) {
		return this.tiles.get(position) == null ? new Tile(position, null) : this.tiles.get(position);
	}
	
	public Map<Position, Tile> getTiles() {
		return this.tiles;
	}
	
	public PieceAlience getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public GameStatus getGameStatus() {
		return this.gameStatus;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<tiles.size(); i++) {
			Piece curPiece = tiles.get(Position.of(i % Uiutils.TILE_COLUMN_NUM + 1, i / Uiutils.TILE_COLUMN_NUM + 1)).getPiece();
			sb.append(String.format("%2s", curPiece == null ? "-" : curPiece.name().substring(0,1) ));
			
			if((i+1) % Uiutils.TILE_COLUMN_NUM == 0) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}


}
