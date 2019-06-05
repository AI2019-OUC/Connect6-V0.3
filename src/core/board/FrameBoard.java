package core.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FrameBoard extends JPanel{
	
	private static char col='J';
	private static char row='J';
	private static final FrameBoard FRAME_BOARD=new FrameBoard(col,row);
	private static int flag=0;//1代表黑子，2代表白子
	private static int step=0;
	private ArrayList<Character> list=new ArrayList<>();
	char[] date= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'};
	private static boolean f=true;
	public FrameBoard(char col,char row) {
		this.col=col;
		this.row=row;
		list.add(col);
		list.add(row);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(100,200));
		this.setBackground(Color.BLUE);
		
		this.setSize(800,690);
		this.setLocation(200,30);
		this.setVisible(true);
	}
	
	public static FrameBoard getInstance() {
		return FRAME_BOARD;
	}
	
	
	
	
	public static int getStep() {
		return step;
	}

	public static void setStep(int step) {
		FrameBoard.step = step;
	}

	public static int getFlag() {
		return flag;
	}

	public static void setFlag(int flag) {
		FrameBoard.flag = flag;
	}

	public static boolean isF() {
		return f;
	}

	public static void setF(boolean f) {
		FrameBoard.f = f;
	}

	public static char getCol() {
		return col;
	}


	public static void setCol(char col) {
		FrameBoard.col = col;
	}


	public static char getRow() {
		return row;
	}


	public static void setRow(char row) {
		FrameBoard.row = row;
	}
	public void draw(PieceColor whoseMove) {
		if(whoseMove==PieceColor.BLACK) {
			flag=1;
		}
		else if(whoseMove==PieceColor.WHITE) {
			flag=2;
		}
		repaint();
	}
	
	public void clear() {
		
		repaint();
	}


	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		if(f) {
			//g.setColor(new Color(249, 214, 91));
			this.setBackground(new Color(249, 214, 91));
			
			g.clearRect(0, 0, 800,690);
			g.setColor(new Color(249, 214, 91));
			g.fillRect(0, 0, 800,690);
			g.setColor(Color.BLACK);
			this.setBackground(new Color(249, 214, 91));
//			this.setOpaque(true);
			drawChessTable(g);
			g.setFont(new Font("微软雅黑", 0, 15));
			g.drawString("六子棋游戏", 660, 60);
		}
		f=false;
		g.fillOval(60+30*9-15, 60+30*9-15, 30,30);
		if(flag==1) {
			step++;
			list.add(col);
			list.add(row);
			g.setColor(Color.BLACK);
			g.fillOval(60+(list.get(2)-'A')*30-15, 60+(list.get(3)-'A')*30-15, 30, 30);
			g.setColor(Color.white);
			g.drawLine(60+(list.get(2)-'A')*30, 60+(list.get(3)-'A')*30-7, 60+(list.get(2)-'A')*30, 60+(list.get(3)-'A')*30+7);
			g.drawLine(60+(list.get(2)-'A')*30-7, 60+(list.get(3)-'A')*30, 60+(list.get(2)-'A')*30+7, 60+(list.get(3)-'A')*30);
			
			if(step>1&&(step%4==0||step%4==1)) {
				g.setColor(Color.black);
				g.fillOval(60+(list.get(0)-'A')*30-15, 60+(list.get(1)-'A')*30-15, 30, 30);
				g.setColor(Color.white);
				g.drawString(String.valueOf(step/2), 60+(list.get(0)-'A')*30-3, 60+(list.get(1)-'A')*30+5);
			}
			if(step>1&&(step%4==2||step%4==3)) {
				g.setColor(Color.white);
				g.fillOval(60+(list.get(0)-'A')*30-15, 60+(list.get(1)-'A')*30-15, 30, 30);
				g.setColor(Color.black);
				g.drawString(String.valueOf(step/2), 60+(list.get(0)-'A')*30-3, 60+(list.get(1)-'A')*30+5);
			}
			list.remove(0);
			list.remove(0);
		}
		if(flag==2) {
			step++;
			list.add(col);
			list.add(row);
			g.setColor(Color.white);
			g.fillOval(60+(list.get(2)-'A')*30-15, 60+(list.get(3)-'A')*30-15, 30, 30);
			g.setColor(Color.black);
			g.drawLine(60+(list.get(2)-'A')*30, 60+(list.get(3)-'A')*30-7, 60+(list.get(2)-'A')*30, 60+(list.get(3)-'A')*30+7);
			g.drawLine(60+(list.get(2)-'A')*30-7, 60+(list.get(3)-'A')*30, 60+(list.get(2)-'A')*30+7, 60+(list.get(3)-'A')*30);
			
			if(step>1&&(step%4==0||step%4==1)) {
				g.setColor(Color.black);
				g.fillOval(60+(list.get(0)-'A')*30-15, 60+(list.get(1)-'A')*30-15, 30, 30);
				g.setColor(Color.white);
				g.drawString(String.valueOf(step/2), 60+(list.get(0)-'A')*30-3, 60+(list.get(1)-'A')*30+5);
			}
			if(step>1&&(step%4==2||step%4==3)) {
				g.setColor(Color.white);
				g.fillOval(60+(list.get(0)-'A')*30-15, 60+(list.get(1)-'A')*30-15, 30, 30);
				g.setColor(Color.black);
				g.drawString(String.valueOf(step/2), 60+(list.get(0)-'A')*30-3, 60+(list.get(1)-'A')*30+5);
			}
			list.remove(0);
			list.remove(0);
		}
	}
	
	
	
	
	public void drawChessTable(Graphics g) {
		
		for(int i=0;i<19;i++) {
			g.drawChars(date, i, 1, 60+30*i-3, 40);
		}
		
		for(int i=0;i<19;i++) {
			g.drawChars(date, i, 1, 33, 60+30*i+3);
		}
		for (int i = 0; i < 19; i++)//起始点距离左右各60，两线之间距离30
			g.drawLine(60, 60+30*i, 60
					+ (19 - 1) * 30, 60 + i
					* 30);
		for (int j = 0; j < 19; j++)
			g.drawLine(60 + j * 30, 60, 60 + j
					* 30, 60 + (19 - 1)
					* 30);
	};
}
