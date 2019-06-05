package core.game;

import java.util.Formatter;

public class Move {

    /** ���������̵�������������Ϊ19 */
    public static final int SIDE = 19;
    /**
     * ��������������������������ַ���ʾ
     */
    public static final char MAXCHAR = 'A' + SIDE-1;

    /** 19*�������й�361�����㣬�����Ͻǵĵ�һ���㿪ʼ�������������°���Щ����Ϊ0-360
     *  MAX_INDEXΪ��ֵ���ĵ㣬��360*/
    static final int MAX_INDEX = SIDE * SIDE - 1;

    /** ����������ĳ�����������������0-360��ʱ���õ����� */
    private static final int
        STEP_C = 1,
        STEP_R = SIDE,
        INDEX_ORIGIN = -('A' * STEP_C + 'A' * STEP_R);
    
    /**
     * �ڣ�col0,row0���ͣ�col1,row1������λ�÷ֱ����һ������
     * @param col0 ��һ�����ӵ�������
     * @param row0 ��һ�����ӵĺ�����
     * @param col1 �ڶ������ӵ�������
     * @param row1 �ڶ������ӵĺ�����
     */
    public Move(char col0, char row0, char col1, char row1) {
    	
    	set(col0, row0, col1, row1);
    }
    /**
     * ��index0��index1����λ�÷ֱ����һ������
     * @param index0 ��һ������λ�õ����Ա�ʾ��0-360��
     * @param index1 �ڶ�������λ�õ����Ա�ʾ��0-360��
     */
    public Move(int index0, int index1)
    {
    	set(index0, index1);
    }
    
    
    /**
     * ���ҽ�����c,r����һ����Ч��λ���Ƿ���true
     * @param c ��λ�õĺ�����
     * @param r ��λ�õ�������
     * @return �Ƿ���һ����Ч��λ��
     */
    public static boolean validSquare(char c, char r) {
        return 'A' <= c && c <= MAXCHAR && 'A' <= r && r <= MAXCHAR;
    }

    
    /**
     * ���ҽ���k��0-360����һ����Ч��λ���Ƿ���true
     * @param k ����λ�õ����Ա�ʾ
     * @return �Ƿ���һ����Ч��λ��
     */
    public static boolean validSquare(int k) {
        return 0 <= k && k <= MAX_INDEX;
    }

    
    /**
     * ���أ�c,r��λ�õ����ӵ����Ա�ʾ��0-360��
     * @param c ���ӵĺ�����
     * @param r ���ӵ�������
     * @return ���ظ�����λ�õ����Ա�ʾ
     */
    public static int index(char c, char r) {
        int k = c * STEP_C + r * STEP_R + INDEX_ORIGIN;
        assert 0 <= k && k <= MAX_INDEX;
        return k;
    }

    /**
     * �������Ա�ʾΪk��0-360��������λ�õ�������
     * @param k ����λ�õ����Ա�ʾ
     * @return �����ӵ�������
     */
    public static char col(int k) {
        return (char) (k % STEP_R + 'A');
    }

    /**
     * �������Ա�ʾΪk��0-360��������λ�õĺ�����
     * @param k ����λ�õ����Ա�ʾ
     * @return �����ӵĺ�����
     */
    public static char row(int k) {
        return (char) (k / STEP_R + 'A');
    }

    /**
     * 
     * @return ���ص�һ�����ӵ�������
     */
    public char col0() {
        return _col0;
    }

    /**
     * 
     * @return ���ص�һ�����ӵĺ�����
     */
    public char row0() {
        return _row0;
    }

    /**
     * 
     * @return ���صڶ������ӵ�������
     */
    public char col1() {
        return _col1;
    }

    /**
     * 
     * @return ���صڶ������ӵĺ�����
     */
    public char row1() {
        return _row1;
    }

    /**
     * 
     * @return ���ص�һ�����ӵ����Ա�ʾ��0-360��
     */
    public int index1() {
        return _index0;
    }

    /**
     * 
     * @return ���صڶ������ӵ����Ա�ʾ(0-360)
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
     * ����strȷ��Ҫ���µ��������ӵ�λ��
     * @param str ���ĸ���ĸ��ɣ�ǰ������ĸ�����һ���ӵĺ������꣬��������ĸ����ڶ����ӵĺ�������
     * @return Move����
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
     * ����Ҫ���µ��������ӵ�λ��
     * @param col0 ��һ�����ӵ�������
     * @param row0 ��һ�����ӵĺ�����
     * @param col1 �ڶ������ӵ�������
     * @param row1 �ڶ������ӵĺ�����
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
     * ����Ҫ���µ��������ӵ�λ��
     * @param ��һ������λ�õ����Ա�ʾ��0-360��
     * @param �ڶ�������λ�õ����Ա�ʾ��0-360��
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

    /** ��һ�����Ӻ͵ڶ������ӵ����Ա�ʾ*/
    private int _index0, _index1;

    /** ��һ�����Ӻ͵ڶ������ӵ��ݺ����� */
    private char _col0, _row0, _col1, _row1;
}
