package core.game;

import core.board.Board;
import core.player.Player;

public class Match {
	public Match() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �½�����
	 * @param gameNumbers ���������ٳ�
	 */
	public Match(int gameNumbers) {
		super();
		this.gameNumbers = gameNumbers;
	}
	/**
	 * �½�ָ����ҵı���
	 * @param gameNumbers ���������ٳ�
	 * @param one ���ĵ�һ��
	 * @param another ���ĵ���һ��
	 */
	public Match(int gameNumbers, Player one, Player another) {
		super();
		this.gameNumbers = gameNumbers;
		this.one = one;
		this.another = another;
	}
	/**
	 * ˫�������Ĺ��̣���˫�����ڶೡ�������������ֽ��У�����˫���������������һ�����one����,�ڶ������two����
	 */
	public void process() {
		
		Player black = one;
		Player white = another;		
		for (int i = 0; i < gameNumbers; i++) {
			System.out.println(black.name() + ": " + white.name() + " - " + (i + 1));
			Board board = new Board();
			Game game = new Game(board, black, white);
			switch (game.process()) {
			case "tie":
				tie++;
				break;
			case "whiteWin":
				if(i%2==0) {
					whiteWin++;
				}
				else {
					blackWin++;
				}
				
				break;
			case "blackWin":
				if(i%2==0) {
					
					blackWin++;
				}
				else {
					whiteWin++;
				}
				break;
			}
			Player temp;
			temp = black;
			black = white;
			white = temp;
		}
		
	}
	
	
	/**
	 * 
	 * @return ����������Ϸ�ı������
	 */
	public GameResult getGameResult() {
		return new GameResult(another.name(),one.name(),gameNumbers,tie, whiteWin, blackWin);
	}
	/**
	 * ˫�������ĳ���
	 */
	private int gameNumbers;	
	
	/**
	 * The first player
	 */
	private Player one;		
	/**
	 * The second player
	 */
	private Player another;	  
	/**
	 * ƽ�ִ���������ʤ������������ʤ������
	 */
	private int tie=0,whiteWin=0,blackWin=0;
}
