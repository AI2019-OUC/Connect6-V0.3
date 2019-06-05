package core.game;

import static core.board.PieceColor.BLACK;
import static core.board.PieceColor.WHITE;

import java.awt.TexturePaint;
import java.io.File;
import java.io.IOException;
import java.util.IllegalFormatCodePointException;

import core.board.Board;
import core.player.Player;

/** 控制玩游戏
 *  @author Jianliang Xu
 */
public class Game {

    /** 一个新的游戏，在棋盘board上玩 */
	public Game(Board board) {
        _board = board;
        _constBoard = _board.constantView();
    }
	/**
	 * 玩家black和white在棋盘board上开始一局新的游戏
	 * @param board 棋盘
	 * @param black 持黑子的一方玩家
	 * @param white 持白子的一方玩家
	 */
	public Game(Board board, Player black, Player white) {
		this(board);
		this.black = black;
		this.white = white;
		black.setColor(BLACK);
		white.setColor(WHITE);
		black.playGame(this);
		white.playGame(this);
	}

	/** 返回当前棋盘的只读视图 */
    public Board board() {
        return _constBoard;
    	//return _board;
    }

    /** 我的棋盘和棋盘的只读视图 */
    private Board _board, _constBoard;
    
    public boolean isValidMove(Move move) {
    	if(Move.validSquare(move.index1())&&Move.validSquare(move.index2())) {
    		return true;
    	}
    	return false;
    }
    
    public void record(File file,String result,String blackName,String whiteName) {
    	try {
			_board.record(file,result,blackName,whiteName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    /**
     * 双方下棋的过程
     * @return 返回游戏的结果，要么白子胜，要么黑子胜，要么平局
     */
    public String process() {
    	Timer timerWhite=new Timer();
    	Timer timerBlack=new Timer();
    	Move currentMove = null;
    	File  file=new File("result.txt");
    	_board.clear();
    	_constBoard.clear();
    	_board.draw();
    	int step = 0;
    	String blackName=black.name();
    	String whiteName=white.name();
        while (true) {    
        	Move move = null;
        	if (_board.whoseMove() == BLACK) {
        		if (black.isManual()) System.out.print("black>");
        		try {
        			timerBlack.restartTime();
        			move = black.findMove(currentMove);
        			timerBlack.stopTime();
        			if(timerBlack.getCountTime()>900) {
        				record(file,"黑方超时，whiteWin",blackName,whiteName);
        				return "whiteWin";
        			}
				} catch (Exception e) {
					System.out.println("黑棋落子出现异常，whiteWin");
					record(file,"黑棋落子出现异常，whiteWin",blackName,whiteName);
					return "whiteWin";
				}
        		if(!isValidMove(move)) {
        			System.out.println("黑棋落子位置非法，whiteWin");
        			record(file,"黑棋落子位置非法，whiteWin",blackName,whiteName);
        			return "whiteWin";
        		}
        	} else {
        		if (white.isManual()) System.out.print("white>");
        		try {
        			timerWhite.restartTime();
        			move = white.findMove(currentMove);
        			timerWhite.stopTime();
        			if(timerWhite.getCountTime()>900) {
        				record(file,"白方超时，blackWin",blackName,whiteName);
        				return "blackWin";
        			}
				} catch (Exception e) {
					System.out.println("白棋落子出现异常，blackWin");
					record(file,"白棋落子出现异常，blackWin",blackName,whiteName);
					return "blackWin";
				}
        		if(!isValidMove(move)) {
        			System.out.println("白棋落子位置非法，blackWin");
        			record(file,"白棋落子位置非法，blackWin",blackName,whiteName);
        			return "blackWin";
        		}
        	}
        	_board.makeMove(move);
        	//_constBoard.makeMove(move);
        	_board.draw();
        	_constBoard.draw(move);
        	currentMove = move;
        	step++;
        	if(step>80) {
        		System.out.println("超过80步,平局");
        		//break;
        		try {
					_board.record(file,"超过80步,平局",blackName,whiteName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		return "tie";
        	}
        	if(_board.gameOver()) {
        		System.out.println(_board.whoseMove().opposite()+"胜利,游戏结束");
        		if(_board.whoseMove().opposite()==WHITE) {
        			try {
						_board.record(file,"whiteWin",blackName,whiteName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			return "whiteWin";
        		}else {
        			try {
						_board.record(file,"blackWin",blackName,whiteName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			return "blackWin";
        		}
        	}
        }
        
       // _constBoard.draw();
    }
    
//    /**  recording the game into a file */
//    public void record(File gameRecord) {
//    	
//    	_board.record(gameRecord);
//    }
    /**
     * 持黑子的一方玩家
     */
    Player black = null;	
    /**
     * 持白子的一方玩家
     */
    Player white = null;    
}
