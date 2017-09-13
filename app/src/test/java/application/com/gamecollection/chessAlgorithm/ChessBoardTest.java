package application.com.gamecollection.chessAlgorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.com.gamecollection.algorithm.chess.model.ChessBoard;
import application.com.gamecollection.algorithm.chess.model.ChessUnit;
import application.com.gamecollection.algorithm.chess.model.UnitType;

/**
 * Created by ssong25 on 9/8/17.
 */

public class ChessBoardTest {

    private ChessBoard chessBoard;

    @Before
    public void setUp() {
        chessBoard = new ChessBoard();
    }

    @After
    public void tearDown() {
        chessBoard = null;
    }


    @Test
    public void testSetUnit() {

    }

    @Test
    public void testUnitMove() {

    }

    @Test
    public void testFailureToMove() {

    }

}
