package io.timpac.engine;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Stack;

import io.timpac.gui.Charim;
import io.timpac.gui.Position;
import io.timpac.piece.Piece;
import io.timpac.piece.PieceAlience;
import io.timpac.piece.PieceType;
import io.timpac.util.Uiutils;

public class Board extends Observable {
	private Map<Position, Tile> tiles = new LinkedHashMap<>(Uiutils.TOTAL_TILE_SIZE);
	private PieceAlience currentPlayer;
	private GameStatus gameStatus;
	private Stack<Move> moveHistory = new Stack<>();
	
	public Board() {
		initialize();
		this.tiles = TileSetup.getBasicTiles();
	}
	
	public void initialize() {
		this.currentPlayer = PieceAlience.CHO;
		this.gameStatus = GameStatus.READY;
		this.moveHistory.clear();
		deleteObservers();
	}
	
	public void tableSetting(Charim choCharim, Charim hanCharim) {
		this.tiles = TileSetup.getSettingTiles(choCharim, hanCharim);
	}
	
	public void makeMove(final Move move) {
		if(isGameOver(move.getDestinationTile())) {
			this.gameStatus = GameStatus.GAME_OVER;
		}else if(this.gameStatus != GameStatus.START) {
			this.gameStatus = GameStatus.START;
		}
		
		getTile(move.getDestinationTile().getPosition()).setPiece(move.getMovedPiece());
		getTile(move.getSourceTile().getPosition()).setPiece(null);
		this.currentPlayer = this.currentPlayer.opponentPlayer();
		
		moveHistory.push(Move.newInstance(move));
		
		setChanged();
		notifyObservers();
	}
	
	public void rewindMove() {
		if(moveHistory.isEmpty()) {
			return;
		}
		
		Move lastMove = moveHistory.pop();
		getTile(lastMove.getSourceTile().getPosition()).setPiece(lastMove.getMovedPiece());
		lastMove.getMovedPiece().setPosition(lastMove.getSourceTile().getPosition());
		getTile(lastMove.getDestinationTile().getPosition()).setPiece(lastMove.getTargetPiece());
		this.currentPlayer = this.currentPlayer.opponentPlayer();
		
		setChanged();
		notifyObservers();
	}
	
	private boolean isGameOver(Tile destinationTile) {
		return destinationTile.hasPiece() 
				&& destinationTile.getPiece().getPieceAlience() != this.currentPlayer 
				&& destinationTile.getPiece().getPieceType() == PieceType.KING;
	}
	
	public void turnOver() {
		this.currentPlayer = this.currentPlayer.opponentPlayer();
		setChanged();
		notifyObservers();
	}
	
	public float calculateTotalScore(PieceAlience pieceAlience) {
		float result = 0f;
		for(Tile tile : this.tiles.values()) {
			if(tile.hasPiece() && tile.getPiece().getPieceAlience() == pieceAlience) {
				result += tile.getPiece().getPieceType().score();
			}
		}
		
		return result + pieceAlience.bonusScore();
	}
	
	public boolean hasMyPiece(Position position) {
		Tile tile = getTile(position);
		return tile.hasPiece() && tile.getPiece().getPieceAlience() == this.currentPlayer; 
	}
	
	public Tile getTile(Position position) {
		return this.tiles.get(position) == null ? new Tile(position, null) : this.tiles.get(position);
	}
	
	public Map<Position, Tile> getTiles() {
		return Collections.unmodifiableMap(tiles);
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
