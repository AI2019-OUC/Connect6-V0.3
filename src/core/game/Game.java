package core.game;

import static core.board.PieceColor.BLACK;
import static core.board.PieceColor.WHITE;

import java.awt.TexturePaint;
import java.io.File;
import java.io.IOException;
import java.util.IllegalFormatCodePointException;

import core.board.Board;
import core.player.Player;

/** ��������Ϸ
 *  @author Jianliang Xu
 */
public class Game {

    /** һ���µ���Ϸ��������board���� */
	public Game(Board board) {
        _board = board;
        _constBoard = _board.constantView();
    }
	/**
	 * ���black��white������board�Ͽ�ʼһ���µ���Ϸ
	 * @param board ����
	 * @param black �ֺ��ӵ�һ�����
	 * @param white �ְ��ӵ�һ�����
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

	/** ���ص�ǰ���̵�ֻ����ͼ */
    public Board board() {
        return _constBoard;
    	//return _board;
    }

    /** �ҵ����̺����̵�ֻ����ͼ */
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
     * ˫������Ĺ���
     * @return ������Ϸ�Ľ����Ҫô����ʤ��Ҫô����ʤ��Ҫôƽ��
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
        				record(file,"�ڷ���ʱ��whiteWin",blackName,whiteName);
        				return "whiteWin";
        			}
				} catch (Exception e) {
					System.out.println("�������ӳ����쳣��whiteWin");
					record(file,"�������ӳ����쳣��whiteWin",blackName,whiteName);
					return "whiteWin";
				}
        		if(!isValidMove(move)) {
        			System.out.println("��������λ�÷Ƿ���whiteWin");
        			record(file,"��������λ�÷Ƿ���whiteWin",blackName,whiteName);
        			return "whiteWin";
        		}
        	} else {
        		if (white.isManual()) System.out.print("white>");
        		try {
        			timerWhite.restartTime();
        			move = white.findMove(currentMove);
        			timerWhite.stopTime();
        			if(timerWhite.getCountTime()>900) {
        				record(file,"�׷���ʱ��blackWin",blackName,whiteName);
        				return "blackWin";
        			}
				} catch (Exception e) {
					System.out.println("�������ӳ����쳣��blackWin");
					record(file,"�������ӳ����쳣��blackWin",blackName,whiteName);
					return "blackWin";
				}
        		if(!isValidMove(move)) {
        			System.out.println("��������λ�÷Ƿ���blackWin");
        			record(file,"��������λ�÷Ƿ���blackWin",blackName,whiteName);
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
        		System.out.println("����80��,ƽ��");
        		//break;
        		try {
					_board.record(file,"����80��,ƽ��",blackName,whiteName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		return "tie";
        	}
        	if(_board.gameOver()) {
        		System.out.println(_board.whoseMove().opposite()+"ʤ��,��Ϸ����");
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
     * �ֺ��ӵ�һ�����
     */
    Player black = null;	
    /**
     * �ְ��ӵ�һ�����
     */
    Player white = null;    
}
