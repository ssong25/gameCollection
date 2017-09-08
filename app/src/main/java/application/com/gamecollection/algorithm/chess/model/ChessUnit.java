package application.com.gamecollection.algorithm.chess.model;

/**
 * Created by ssong25 on 8/17/17.
 */

public class ChessUnit {

    private boolean isColorWhite;
    private UnitType unitType;

    public ChessUnit(boolean isWhite, UnitType type) {
        isColorWhite = isWhite;
        unitType = type;
    }


    public boolean canMoveTo(ChessBoard board, int from_x, int from_y, int to_x, int to_y) {
        //TODO: check if unit can move to the to coordinate corresponding with unit type.
        switch(unitType) {
            case KING:
                return checkKingMove(board, from_x, from_y, to_x, to_y);
            case QUEEN:
            return checkQueenMove(board, from_x, from_y, to_x, to_y);
            case ROOK:
                return checkRookMove(board, from_x, from_y, to_x, to_y);
            case BISHOP:
                return checkBishopMove(board, from_x, from_y, to_x, to_y);
            case KNIGHT:
                return checkKnightMove(board, from_x, from_y, to_x, to_y);
            case PAWN:
                return checkPawnMove(board, from_x, from_y, to_x, to_y);
            default:
                return false;
        }
    }

    public int[] getAvailableMoves(ChessBoard board, int from_x, int from_y) {
        //TODO: return all available moves in integer arr as int [x, y, x, y, ...].
        switch(unitType) {
            case KING:
                return new int[0];
            case QUEEN:
                return new int[0];
            case ROOK:
                return new int[0];
            case BISHOP:
                return new int[0];
            case KNIGHT:
                return new int[0];
            case PAWN:
                return new int[0];
            default:
                return new int[0];
        }
    }

    public boolean isUnitWhite() {
        return isColorWhite;
    }


    private boolean checkKingMove(ChessBoard board, int from_x, int from_y, int to_x, int to_y) {

        if((to_x < 0 || to_x >= ChessBoard.BOARD_LEN)
                || (to_y < 0 || to_y >= ChessBoard.BOARD_LEN)
                || (from_x == to_x && from_y == to_y))
            return false;

        int x_gap = Math.abs(from_x - to_x);
        int y_gap = Math.abs(from_y - to_y);
        if(x_gap <= 1 && y_gap <= 1) {
            if(board.isThereUnit(to_x, to_y))
                return board.isUnitWhite(to_x, to_y) != isUnitWhite();
            else
                return true;
        }
        return false;
    }

    private boolean checkQueenMove(ChessBoard board, int from_x, int from_y, int to_x, int to_y) {

        if((to_x < 0 || to_x >= ChessBoard.BOARD_LEN)
                || (to_y < 0 || to_y >= ChessBoard.BOARD_LEN)
                || (from_x == to_x && from_y == to_y))
            return false;

        return checkRookMove(board, from_x, from_y, to_x, to_y)
                || checkBishopMove(board, from_x, from_y, to_x, to_y);
    }

    private boolean checkRookMove(ChessBoard board, int from_x, int from_y, int to_x, int to_y) {

        if((to_x < 0 || to_x >= ChessBoard.BOARD_LEN)
                || (to_y < 0 || to_y >= ChessBoard.BOARD_LEN)
                || (from_x == to_x && from_y == to_y))
            return false;

        //the same row
        if(from_x == to_x) {
            int min = Math.min(from_y, to_y);
            int max = Math.max(from_y, to_y);
            boolean result = board.isThereUnit(to_x, to_y)?
                    board.isUnitWhite(to_x, to_y) != isUnitWhite() : true;
            for(int i = min+1; i < max; ++i)
                result &= !board.isThereUnit(from_x, i);
            return result;
        }
        //the same column
        else if(from_y == to_y) {
            int min = Math.min(from_x, to_x);
            int max = Math.max(from_x, to_x);
            boolean result = board.isThereUnit(to_x, to_y)?
                    board.isUnitWhite(to_x, to_y) != isUnitWhite() : true;;
            for(int i = min+1; i < max; ++i)
                result &= !board.isThereUnit(i, from_y);
            return result;
        }
        return false;
    }

    private boolean checkBishopMove(ChessBoard board, int from_x, int from_y, int to_x, int to_y) {

        if((to_x < 0 || to_x >= ChessBoard.BOARD_LEN)
                || (to_y < 0 || to_y >= ChessBoard.BOARD_LEN)
                || (from_x == to_x && from_y == to_y))
            return false;

        //on the diagonal.
        int x_gap = from_x - to_x;
        int y_gap = from_y - to_y;
        if(Math.abs(x_gap) == Math.abs(y_gap)) {
            //on the diagonal from upper left to lower right.
            if((x_gap > 0 && y_gap > 0) || (x_gap < 0 && y_gap < 0)) {
                boolean result = board.isThereUnit(to_x, to_y)?
                        board.isUnitWhite(to_x, to_y) != isUnitWhite() : true;
                for(int i = 1; i < Math.abs(x_gap); ++i) {
                    if(x_gap > 0)
                        result &= !board.isThereUnit(from_x-i, from_y-i);
                    else
                        result &= !board.isThereUnit(from_x+i, from_y+i);
                }
                return result;
            }
            //on the diagonal from upper right to lower left.
            else if((x_gap < 0 && y_gap > 0) || (x_gap > 0 && y_gap < 0)) {
                boolean result = board.isThereUnit(to_x, to_y)?
                        board.isUnitWhite(to_x, to_y) != isUnitWhite() : true;
                for(int i = 1; i < Math.abs(x_gap); ++i) {
                    if(x_gap < 0)
                        result &= !board.isThereUnit(from_x+i, from_y-i);
                    else
                        result &= !board.isThereUnit(from_x-i, from_y+i);
                }
                return  result;
            }
        }
        return false;
    }

    private boolean checkKnightMove(ChessBoard board, int from_x, int from_y, int to_x, int to_y) {

        if((to_x < 0 || to_x >= ChessBoard.BOARD_LEN)
                || (to_y < 0 || to_y >= ChessBoard.BOARD_LEN)
                || (from_x == to_x && from_y == to_y))
            return false;

        int x_gap = from_x - to_x;
        int y_gap = from_y - to_y;
        if((Math.abs(y_gap) == 2 && Math.abs(x_gap) == 1)
                || (Math.abs(y_gap) == 1 && Math.abs(x_gap) == 2)) {
            return board.isThereUnit(to_x, to_y)?
                    (board.isUnitWhite(to_x, to_y) != isUnitWhite()) : true;
        }
        return false;
    }

    private boolean checkPawnMove(ChessBoard board, int from_x, int from_y, int to_x, int to_y) {

        if((to_x < 0 || to_x >= ChessBoard.BOARD_LEN)
                || (to_y < 0 || to_y >= ChessBoard.BOARD_LEN))
            return false;

        //always my units start from the bottom row of the board.
        if(from_x-1 == to_x) {
            if(from_y == to_y) {
                return !board.isThereUnit(to_x, to_y);
            }
            else if(from_y-1 == to_y || from_y+1 == to_y) {
                if(board.isThereUnit(to_x, to_y))
                    return board.isUnitWhite(to_x, to_y) != isUnitWhite();
                else
                    return false;
            }
        }

        return false;
    }




}
