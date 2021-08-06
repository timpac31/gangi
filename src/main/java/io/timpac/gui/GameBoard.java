package io.timpac.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import io.timpac.engine.Board;

public class GameBoard {
	private static Dimension GAMEBOARD_SIZE = new Dimension(600, 600);
	
	private final Board board;
	private final JFrame gameFrame;
	private final BoardPanel boardPanel;
	private final DisplayPanel displayPanel;
	
	public GameBoard() {
		this.gameFrame = new JFrame("장기게임");
		this.gameFrame.setSize(GAMEBOARD_SIZE);
		this.board = new Board();
		this.boardPanel = new BoardPanel(board);
		this.gameFrame.add(boardPanel, BorderLayout.CENTER);
		this.displayPanel = new DisplayPanel(board);
		this.gameFrame.add(displayPanel, BorderLayout.EAST);		
		this.board.addObserver(displayPanel);
		this.board.addObserver(boardPanel);
		
		createMenu();		
		this.gameFrame.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar menubar = new JMenuBar();
		menubar.add(createFileMenu());
		this.gameFrame.setJMenuBar(menubar);
	}

	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		return fileMenu;
	}
}
