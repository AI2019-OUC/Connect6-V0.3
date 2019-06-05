package core.board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PublicKey;
import java.util.Collections;
import java.util.IllegalFormatCodePointException;

import javax.swing.JFrame;

import core.game.Move;

public class Frame extends JFrame{
	
	private static char col='J';
	private static char row='J';
	private static final Frame frame=new Frame(col,row);
	
	private static final FrameBoard FRAME_BOARD=FrameBoard.getInstance();
	public char getCol() {
		return col;
	}

	public void setCol(char col) {
		this.col = col;
	}

	public char getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}

	private Frame(char col,char row) {
		this.col=col;
		this.row=row;
		this.setBackground(new Color(249, 214, 91));
		this.getContentPane().setBackground(new Color(249, 214, 91));
		this.setTitle("Áù×ÓÆå");
		this.setSize(800,690);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,30);
		this.setVisible(true);
	}
	public void draw(PieceColor whoseMove) {
		FRAME_BOARD.setCol(col);
		FRAME_BOARD.setRow(row);
		FRAME_BOARD.draw(whoseMove);
	}
	
	public void clear() {
		FRAME_BOARD.setFlag(0);
		FRAME_BOARD.setF(true);
		FRAME_BOARD.setStep(0);
		FRAME_BOARD.clear();
	}
	

	
	public static Frame getInstance() {
		return frame;
	}
	

}
