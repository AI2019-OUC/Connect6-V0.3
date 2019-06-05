package core.game;


/**
 * 比赛的结果
 * @author Jianliang Xu
 *
 */
public class GameResult {
	/**
	 * 持白子一方的名字
	 */
	private String whiteName;
	/**
	 * 持黑子一方的名字
	 */
	private String blackName;
	/**
	 * 两方共对弈多少局
	 */
	private int gameNumbers;
	/**
	 * 平局的次数
	 */
	private int tie;
	/**
	 * 白子胜利次数
	 */
	private int whiteWin;
	/**
	 * 黑子胜利次数
	 */
	private int blackWin;
	/**
	 * 
	 * @param whiteName 持白子一方的名字
	 * @param blackName 持黑子一方的名字
	 * @param gameNumbers 两方共对弈多少局
	 * @param tie 平局次数
	 * @param whiteWin 白子胜利次数
	 * @param blackWin 黑子胜利次数
	 */
	public GameResult(String whiteName,String blackName,int gameNumbers,int tie,int whiteWin,int blackWin) {
		// TODO Auto-generated constructor stub
		this.whiteName=whiteName;
		this.blackName=blackName;
		this.gameNumbers=gameNumbers;
		this.tie=tie;
		this.blackWin=blackWin;
		this.whiteWin=whiteWin;
	}
	
	
	
	public String getWhiteName() {
		return whiteName;
	}



	public void setWhiteName(String whiteName) {
		this.whiteName = whiteName;
	}



	public String getBlackName() {
		return blackName;
	}



	public void setBlackName(String blackName) {
		this.blackName = blackName;
	}



	public int getGameNumbers() {
		return gameNumbers;
	}



	public void setGameNumbers(int gameNumbers) {
		this.gameNumbers = gameNumbers;
	}



	public int getTie() {
		return tie;
	}
	public void setTie(int tie) {
		this.tie = tie;
	}
	public int getWhiteWin() {
		return whiteWin;
	}
	public void setWhiteWin(int whiteWin) {
		this.whiteWin = whiteWin;
	}
	public int getBlackWin() {
		return blackWin;
	}
	public void setBlackWin(int blackWin) {
		this.blackWin = blackWin;
	}
	
}
