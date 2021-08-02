package io.timpac.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SwingTest {

	public static void main(String[] args) {
		JFrame jframe = new JFrame("test");
		jframe.setSize(new Dimension(600, 300));
		
		JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new GridLayout(1, 2));
		layoutPanel.setPreferredSize(new Dimension(400, 200));
		
		JPanel insidePanel = new JPanel();
		insidePanel.setLayout(new GridBagLayout());
		insidePanel.setPreferredSize(new Dimension(200, 200));
		insidePanel.setBackground(Color.red);
		
		try {
			BufferedImage image = ImageIO.read(new File("asset/images/HAN_King.png"));
			insidePanel.add(new JLabel(new ImageIcon(image)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		insidePanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		insidePanel.validate();
		
		JPanel insidePanel2 = new JPanel();
		insidePanel2.setLayout(new GridBagLayout());
		insidePanel2.setPreferredSize(new Dimension(200, 200));
		insidePanel2.setBackground(Color.blue);
		
		try {
			BufferedImage image = ImageIO.read(new File("asset/images/CHO_Cha.png"));
			insidePanel2.add(new JLabel(new ImageIcon(image)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		insidePanel2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JLabel pieceIcon = (JLabel) insidePanel2.getComponent(0);
				pieceIcon.setBorder(BorderFactory.createLineBorder(Color.CYAN));				
			}
		});
		
		insidePanel2.validate();
		
		layoutPanel.add(insidePanel);
		layoutPanel.add(insidePanel2);
		layoutPanel.validate();
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(createFileMenu());
		
		jframe.add(layoutPanel,  BorderLayout.CENTER);
		jframe.setJMenuBar(menubar);
		jframe.setVisible(true);
	}
	
	
	private static JMenu createFileMenu() {
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
