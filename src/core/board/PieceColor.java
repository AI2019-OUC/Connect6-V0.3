package core.board;

/** 用于描述六子棋棋盘上的棋子.
 *  @author Jianliang Xu
 */
public enum PieceColor {

    /** EMPTY: 没有棋子.
     *  BLACK, WHITE: 棋子的颜色. */
    EMPTY,
    BLACK {
    	/**
    	 * 返回WHITE
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
    	 * 返回BLACK
    	 */
        @Override
        public PieceColor opposite() {
            return BLACK;
        }
        /**
         * 返回true，即有棋子
         */
        @Override
        boolean isPiece() {
            return true;
        }
    };

    /** 返回对手棋子的颜色 */
    public PieceColor opposite() {
        throw new UnsupportedOperationException();
    }

    /** 当有棋子时返回true,无棋子时返回false */
    boolean isPiece() {
        return false;
    }

    /** 
     *  用一个字符代表棋子，黑子用b表示，白子用w表示，空用-表示 */
    String shortName() {
        return this == BLACK ? "b" : this == WHITE ? "w" : "-";
    }

    @Override
    public String toString() {
        return capitalize(super.toString().toLowerCase());
    }

    /** 将word的首字母转为大写并返回 */
    static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
