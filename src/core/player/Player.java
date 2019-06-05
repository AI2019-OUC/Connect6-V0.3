package core.player;

import core.board.Board;
import core.board.PieceColor;
import core.game.Game;
import core.game.Move;

/** 
 *  六子棋玩家
 */
public abstract class Player {
  
	public abstract boolean isManual();
	/**
	 * 
	 * @return 玩家的名字
	 */
	public abstract String name();
	/**
	 * 
	 * @return 玩家所持棋子的颜色
	 */
    public PieceColor getColor() {
		return _myColor;
	}
    
    /** 设置玩家所持棋子的颜色 */
	public void setColor(PieceColor myColor) {
		_myColor = myColor;
	}


	/** 返回一个六子棋游戏 */
	public Game game() {
        return _game;
    }
	
	/** 加入游戏. */
	public void playGame(Game game) {
		_game = game;
	}
   
    /** Return a legal move for me according to my opponent's move.
     *  Abstract method to be implemented by subclasses. */
	public abstract Move findMove(Move opponentMove);

    /** 玩家参与的六子棋游戏 */
    private Game _game;
    
    /** 当前玩家所持棋子的颜色 */
    private PieceColor _myColor;

}
