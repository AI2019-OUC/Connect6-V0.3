package core.board;

/** �������������������ϵ�����.
 *  @author Jianliang Xu
 */
public enum PieceColor {

    /** EMPTY: û������.
     *  BLACK, WHITE: ���ӵ���ɫ. */
    EMPTY,
    BLACK {
    	/**
    	 * ����WHITE
    	 */
        @Override
        public PieceColor opposite() {
            return WHITE;
        }

        @Override
        boolean isPiece() {
            return true;
        }
    },
    WHITE {
    	/**
    	 * ����BLACK
    	 */
        @Override
        public PieceColor opposite() {
            return BLACK;
        }
        /**
         * ����true����������
         */
        @Override
        boolean isPiece() {
            return true;
        }
    };

    /** ���ض������ӵ���ɫ */
    public PieceColor opposite() {
        throw new UnsupportedOperationException();
    }

    /** ��������ʱ����true,������ʱ����false */
    boolean isPiece() {
        return false;
    }

    /** 
     *  ��һ���ַ��������ӣ�������b��ʾ��������w��ʾ������-��ʾ */
    String shortName() {
        return this == BLACK ? "b" : this == WHITE ? "w" : "-";
    }

    @Override
    public String toString() {
        return capitalize(super.toString().toLowerCase());
    }

    /** ��word������ĸתΪ��д������ */
    static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
