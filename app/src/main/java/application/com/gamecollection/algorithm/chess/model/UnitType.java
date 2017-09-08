package application.com.gamecollection.algorithm.chess.model;

/**
 * Created by ssong25 on 8/28/17.
 */

public enum UnitType {

    KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN, NONE;


    public static UnitType getUnitTypeByInteger(int type) {
        switch(type) {
            case 0:
                return KING;
            case 1:
                return QUEEN;
            case 2:
                return ROOK;
            case 3:
                return KNIGHT;
            case 4:
                return BISHOP;
            case 5:
                return PAWN;
            default:
                return NONE;
        }
    }

    public static int getIntegerByUnitType(UnitType type) {
        switch(type) {
            case KING:
                return 0;
            case QUEEN:
                return 1;
            case ROOK:
                return 2;
            case KNIGHT:
                return 3;
            case BISHOP:
                return 4;
            case PAWN:
                return 5;
            default:
                return -1;
        }
    }


}
