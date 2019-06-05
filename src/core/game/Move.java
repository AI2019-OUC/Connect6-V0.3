package core.game;

import java.util.Formatter;

public class Move {

    /** 六子棋棋盘的行数和列数，为19 */
    public static final int SIDE = 19;
    /**
     * 六子棋棋盘最大行数和列数的字符表示
     */
    public static final char MAXCHAR = 'A' + SIDE-1;

    /** 19*的棋盘中共361个交点，从左上角的第一个点开始，依次向右向下把这些点标记为0-360
     *  MAX_INDEX为数值最大的点，即360*/
    static final int MAX_INDEX = SIDE * SIDE - 1;

    /** 计算棋盘上某个交点的线性描述（0-360）时常用的数据 */
    private static final int
        STEP_C = 1,
        STEP_R = SIDE,
        INDEX_ORIGIN = -('A' * STEP_C + 'A' * STEP_R);
    
    /**
     * 在（col0,row0）和（col1,row1）两个位置分别放置一个棋子
     * @param col0 第一个棋子的纵坐标
     * @param row0 第一个棋子的横坐标
     * @param col1 第二个棋子的纵坐标
     * @param row1 第二个棋子的横坐标
     */
    public Move(char col0, char row0, char col1, char row1) {
    	
    	set(col0, row0, col1, row1);
    }
    /**
     * 在index0和index1两个位置分别放置一个棋子
     * @param index0 第一个棋子位置的线性表示（0-360）
     * @param index1 第二个棋子位置的线性表示（0-360）
     */
    public Move(int index0, int index1)
    {
    	set(index0, index1);
    }
    
    
    /**
     * 当且仅当（c,r）是一个有效的位置是返回true
     * @param c 该位置的横坐标
     * @param r 该位置的纵坐标
     * @return 是否是一个有效的位置
     */
    public static boolean validSquare(char c, char r) {
        return 'A' <= c && c <= MAXCHAR && 'A' <= r && r <= MAXCHAR;
    }

    
    /**
     * 当且仅当k（0-360）是一个有效的位置是返回true
     * @param k 棋子位置的线性表示
     * @return 是否是一个有效的位置
     */
    public static boolean validSquare(int k) {
        return 0 <= k && k <= MAX_INDEX;
    }

    
    /**
     * 返回（c,r）位置的棋子的线性表示（0-360）
     * @param c 棋子的横坐标
     * @param r 棋子的纵坐标
     * @return 返回该棋子位置的线性表示
     */
    public static int index(char c, char r) {
        int k = c * STEP_C + r * STEP_R + INDEX_ORIGIN;
        assert 0 <= k && k <= MAX_INDEX;
        return k;
    }

    /**
     * 返回线性表示为k（0-360）的棋子位置的纵坐标
     * @param k 棋子位置的线性表示
     * @return 该棋子的纵坐标
     */
    public static char col(int k) {
        return (char) (k % STEP_R + 'A');
    }

    /**
     * 返回线性表示为k（0-360）的棋子位置的横坐标
     * @param k 棋子位置的线性表示
     * @return 该棋子的横坐标
     */
    public static char row(int k) {
        return (char) (k / STEP_R + 'A');
    }

    /**
     * 
     * @return 返回第一个棋子的纵坐标
     */
    public char col0() {
        return _col0;
    }

    /**
     * 
     * @return 返回第一个棋子的横坐标
     */
    public char row0() {
        return _row0;
    }

    /**
     * 
     * @return 返回第二个棋子的纵坐标
     */
    public char col1() {
        return _col1;
    }

    /**
     * 
     * @return 返回第二个棋子的横坐标
     */
    public char row1() {
        return _row1;
    }

    /**
     * 
     * @return 返回第一个棋子的线性表示（0-360）
     */
    public int index1() {
        return _index0;
    }

    /**
     * 
     * @return 返回第二个棋子的线性表示(0-360)
     */
    public int index2() {
        return _index1;
    }

    @Override
    public int hashCode() {
        return (_index0 << 8) | _index1;
    }

    @Override
    public boolean equals(Object obj) {
        Move m = (Move) obj;
        return _index0 == m._index0 && _index1 == m._index1;
    }

    /** Return the Move denoted by STR. */
    /**
     * 根据str确定要落下的两个棋子的位置
     * @param str 由四个字母组成，前两个字母代表第一个子的横纵坐标，后两个字母代表第二个子的横纵坐标
     * @return Move对象
     */
    public static Move parseMove(String str) {
        return new Move(str.charAt(0), str.charAt(1), str.charAt(2), str.charAt(3));
    }
    
    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%c%c%c%c", _col0, _row0, _col1, _row1);
        String str = out.toString();
        out.close();
        return str;
    }

    /**
     * 设置要落下的两个棋子的位置
     * @param col0 第一个棋子的纵坐标
     * @param row0 第一个棋子的横坐标
     * @param col1 第二个棋子的纵坐标
     * @param row1 第二个棋子的横坐标
     */
    private void set(char col0, char row0, char col1, char row1) {
        _col0 = col0;
        _row0 = row0;
        _col1 = col1;
        _row1 = row1;
        _index0 = index(col0, row0);
        if (col1 == '@' && row1 == '@')
        	_index1 = -1;
        else
        	_index1 = index(col1, row1);
    }
    
    /**
     * 设置要落下的两个棋子的位置
     * @param 第一个棋子位置的线性表示（0-360）
     * @param 第二个棋子位置的线性表示（0-360）
     */
    private void set(int index0, int index1) {
    	_col0 = col(index0);
    	_col1 = col(index1);
    	_row0 = row(index0);
    	_row1 = row(index1);
    	_index0 = index0; 
    	_index1 = index1;
    }
    
    
    public boolean isFirst()
    {
    	return _col1 == '@' && _row1 == '@';
    }

    /** 第一个棋子和第二个棋子的线性表示*/
    private int _index0, _index1;

    /** 第一个棋子和第二个棋子的纵横坐标 */
    private char _col0, _row0, _col1, _row1;
}
