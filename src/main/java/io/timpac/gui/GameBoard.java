package io.timpac.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;

import io.timpac.engine.Board;

public class GameBoard {
	private static Dimension GAMEBOARD_SIZE = new Dimension(650, 600);
	
	private final Board board;
	private final JFrame gameFrame;
	private BoardPanel boardPanel;
	private DisplayPanel displayPanel;
	private final JFrame tableOptionFrame;
	
	public GameBoard() {
		this.gameFrame = new JFrame("장기게임");
		this.gameFrame.setSize(GAMEBOARD_SIZE);
		this.board = new Board();
		this.tableOptionFrame = createOptionWindow();
		
		createMenu();
		this.gameFrame.setVisible(true);
	}
	
	private void start() {
		this.gameFrame.getContentPane().removeAll();
		this.boardPanel = new BoardPanel(board);
		this.gameFrame.add(boardPanel, BorderLayout.CENTER);
		this.displayPanel = new DisplayPanel(board);
		this.gameFrame.add(displayPanel, BorderLayout.EAST);
		this.board.addObserver(displayPanel);
		this.board.addObserver(boardPanel);
		this.gameFrame.setVisible(true);
	}
	
	private JFrame createOptionWindow() {
		JFrame f = new JFrame();
		
		JLabel choLabel = new JLabel("초 상차림");
		JLabel hanLabel = new JLabel("한 상차림");
		choLabel.setBounds(10, 150, 100, 30);
		hanLabel.setBounds(10, 20, 100, 30);
		
		JRadioButton cho1 = new JRadioButton("상 마 상 마", true);
		JRadioButton cho2 = new JRadioButton("상 마 마 상");
		JRadioButton cho3 = new JRadioButton("마 상 마 상");
		JRadioButton cho4 = new JRadioButton("마 상 상 마");
		JRadioButton han1 = new JRadioButton("상 마 상 마", true);
		JRadioButton han2 = new JRadioButton("상 마 마 상");
		JRadioButton han3 = new JRadioButton("마 상 마 상");
		JRadioButton han4 = new JRadioButton("마 상 상 마");
		
		cho1.setBounds(100,150,100,30);
		cho2.setBounds(100,180,100,30);
		cho3.setBounds(100,210,100,30);
		cho4.setBounds(100,240,100,30);
		han1.setBounds(100,20,100,30);
		han2.setBounds(100,50,100,30);
		han3.setBounds(100,80,100,30);
		han4.setBounds(100,110,100,30);
				
		ButtonGroup choOption = new ButtonGroup();
		ButtonGroup hanOption = new ButtonGroup();
		choOption.add(cho1); choOption.add(cho2); choOption.add(cho3); choOption.add(cho4);
		hanOption.add(han1); hanOption.add(han2); hanOption.add(han3); hanOption.add(han4);
		
		JButton button = new JButton("선택");
		button.setBounds(100, 270, 80, 30);
		button.addActionListener(e -> {
			Charim choCharim = null;
			Charim hanCharim = null;
			if(cho1.isSelected()) {
				choCharim = Charim.SMSM;
			}else if(cho2.isSelected()) {
				choCharim = Charim.SMMS;
			}else if(cho3.isSelected()) {
				choCharim = Charim.MSMS;
			}else if(cho4.isSelected()) {
				choCharim = Charim.MSSM;
			}
			
			if(han1.isSelected()) {
				hanCharim = Charim.SMSM;
			}else if(han2.isSelected()) {
				hanCharim = Charim.SMMS;
			}else if(han3.isSelected()) {
				hanCharim = Charim.MSMS;
			}else if(han4.isSelected()) {
				hanCharim = Charim.MSSM;
			}
			
			board.initialize();
			board.tableSetting(choCharim, hanCharim);
			start();
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		});

		f.add(choLabel); f.add(hanLabel);
		f.add(cho1); f.add(cho2); f.add(cho3); f.add(cho4);
		f.add(han1); f.add(han2); f.add(han3); f.add(han4);
		f.add(button);
		f.setSize(300, 350);
		
		f.setLayout(null);
		f.setVisible(false);
		
		return f;
	}
	
	private void showOptionWindow() {
		this.tableOptionFrame.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar menubar = new JMenuBar();
		menubar.add(newGameMenu());
		menubar.add(createOperationMenu());
		this.gameFrame.setJMenuBar(menubar);
	}
	
	private JMenu newGameMenu() {
		JMenu menu = new JMenu("Game");
		JMenuItem startItem = new JMenuItem("New Game");
		startItem.addActionListener(e -> showOptionWindow());
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(e -> System.exit(0));
		menu.add(startItem);
		menu.add(exitItem);
		return menu;
	}
	
	private JMenu createOperationMenu() {
		JMenu menu = new JMenu("동작");
		JMenuItem rewindItem = new JMenuItem("무르기");
		rewindItem.addActionListener(e -> {
			board.rewindMove();
		});
		JMenuItem turnoverItem = new JMenuItem("한수 쉼");
		turnoverItem.addActionListener(e -> {
			board.turnOver();
		});
		menu.add(rewindItem);
		menu.add(turnoverItem);
		return menu;
	}
	
}
