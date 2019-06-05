package core.player;

import core.board.Board;
import core.board.PieceColor;
import core.game.Game;
import core.game.Move;

/** 
 *  ���������
 */
public abstract class Player {
  
	public abstract boolean isManual();
	/**
	 * 
	 * @return ��ҵ�����
	 */
	public abstract String name();
	/**
	 * 
	 * @return ����������ӵ���ɫ
	 */
    public PieceColor getColor() {
		return _myColor;
	}
    
    /** ��������������ӵ���ɫ */
	public void setColor(PieceColor myColor) {
		_myColor = myColor;
	}


	/** ����һ����������Ϸ */
	public Game game() {
        return _game;
    }
	
	/** ������Ϸ. */
	public void playGame(Game game) {
		_game = game;
	}
   
    /** Return a legal move for me according to my opponent's move.
     *  Abstract method to be implemented by subclasses. */
	public abstract Move findMove(Move opponentMove);

    /** ��Ҳ������������Ϸ */
    private Game _game;
    
    /** ��ǰ����������ӵ���ɫ */
    private PieceColor _myColor;

}
