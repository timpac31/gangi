package io.timpac.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.timpac.engine.Board;
import io.timpac.piece.PieceAlience;

public class DisplayPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private static final Dimension DISPLAY_SIZE = new Dimension(80, 600);
	
	private final Board board;
	private final DataModel dataModel;
	
	DisplayPanel(Board board) {
		super(new BorderLayout());
		this.board = board;
		this.dataModel = new DataModel();
		JTable jtable = new JTable(dataModel);
		jtable.setRowHeight(300);
		add(jtable);
		
		setPreferredSize(DISPLAY_SIZE);
		setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//System.out.println("Notify by Board.makeMove()");
		//System.out.println(board.toString());
		
		this.dataModel.setRowCount(0);
		this.dataModel.setValueAt(board.calculateTotalScore(PieceAlience.HAN), 0, 0);
		this.dataModel.setValueAt(board.calculateTotalScore(PieceAlience.CHO), 1, 0);
	}
	
	
	private static class DataModel extends DefaultTableModel {
		private static final long serialVersionUID = 1L;
		private float choScore = 72;
		private float hanScore = 73.5f;
		
		@Override
		public Object getValueAt(int row, int column) {
			if(row == 0) {
				return this.hanScore;
			}else if(row == 1) {
				return this.choScore;
			}
			
			throw new IllegalArgumentException("row는 0, 1만 가능합니다");
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			if(row == 0) {
				this.hanScore = (float)aValue;
			}else if(row == 1) {
				this.choScore = (float)aValue;
			}
		}
		
		@Override
		public int getRowCount() {
			return 2;
		}

		@Override
		public int getColumnCount() {
			return 1;
		}
	}
	
}
