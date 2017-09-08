package application.com.gamecollection.algorithm.chess.model;

/**
 * Created by ssong25 on 8/28/17.
 */

public class ChessBoard {

    public static final int BOARD_LEN = 8;


    private ChessUnit[][] board;

    public ChessBoard() {
        board = new ChessUnit[BOARD_LEN][BOARD_LEN];
        for(int i = 0; i < BOARD_LEN; ++i)
            for(int j = 0; j < BOARD_LEN; ++j)
                board[i][j] = null;
    }


    public void setUnit(ChessUnit unit, int x, int y) {
        board[x][y] = unit;
    }

    public boolean move(int from_x, int from_y, int to_x, int to_y) {
        // move ChessUnit at the position of from_coordinate to to_coordinate.
        ChessUnit unit = board[from_x][from_y];
        if(unit == null)
            return false;
        if(unit.canMoveTo(this, from_x, from_y, to_x, to_y)) {
            board[to_x][to_y] = unit;
            board[from_x][from_y] = null;

            return true;
        }
        return false;
    }

    public boolean isThereUnit(int x, int y) {
        return board[x][y] != null;
    }

    public boolean isUnitWhite(int x, int y) {
        if(board[x][y] == null)
            throw new NullPointerException("No chess Unit at (" + x + " , " + y + ")");

        return board[x][y].isUnitWhite();
    }

}
