package core.game;

import core.board.Board;
import core.player.Player;

public class Match {
	public Match() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 新建比赛
	 * @param gameNumbers 共比赛多少场
	 */
	public Match(int gameNumbers) {
		super();
		this.gameNumbers = gameNumbers;
	}
	/**
	 * 新建指定玩家的比赛
	 * @param gameNumbers 共比赛多少场
	 * @param one 对弈的一方
	 * @param another 对弈的另一方
	 */
	public Match(int gameNumbers, Player one, Player another) {
		super();
		this.gameNumbers = gameNumbers;
		this.one = one;
		this.another = another;
	}
	/**
	 * 双方比赛的过程，若双方存在多场比赛，则交替先手进行，例如双方比赛两场，则第一场玩家one先手,第二场玩家two先手
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
	 * @return 返回整个游戏的比赛结果
	 */
	public GameResult getGameResult() {
		return new GameResult(another.name(),one.name(),gameNumbers,tie, whiteWin, blackWin);
	}
	/**
	 * 双方比赛的场数
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
	 * 平局次数，白子胜利次数，黑子胜利次数
	 */
	private int tie=0,whiteWin=0,blackWin=0;
}
