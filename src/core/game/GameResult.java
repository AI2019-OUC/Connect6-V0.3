package core.game;


/**
 * �����Ľ��
 * @author Jianliang Xu
 *
 */
public class GameResult {
	/**
	 * �ְ���һ��������
	 */
	private String whiteName;
	/**
	 * �ֺ���һ��������
	 */
	private String blackName;
	/**
	 * ���������Ķ��پ�
	 */
	private int gameNumbers;
	/**
	 * ƽ�ֵĴ���
	 */
	private int tie;
	/**
	 * ����ʤ������
	 */
	private int whiteWin;
	/**
	 * ����ʤ������
	 */
	private int blackWin;
	/**
	 * 
	 * @param whiteName �ְ���һ��������
	 * @param blackName �ֺ���һ��������
	 * @param gameNumbers ���������Ķ��پ�
	 * @param tie ƽ�ִ���
	 * @param whiteWin ����ʤ������
	 * @param blackWin ����ʤ������
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
