package io.timpac.engine;

import io.timpac.gui.GameBoard;

public class Game {
	public static void main(String[] args) {
		printLogo();
		new GameBoard();
	}
	
	private static void printLogo() {
		System.out.format("=====================================\n");
		System.out.format("%20s\n", "장기 게임");
		System.out.format("%s\n", "version: 1.0");
		System.out.format("%s\n", "만든이: 조영덕");
		System.out.format("%s\n", "https://github.com/timpac31/gangi");
		System.out.format("=====================================\n");
	}
}
