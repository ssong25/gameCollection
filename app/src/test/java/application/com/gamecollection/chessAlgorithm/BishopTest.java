package application.com.gamecollection.chessAlgorithm;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.com.gamecollection.algorithm.chess.model.ChessBoard;
import application.com.gamecollection.algorithm.chess.model.ChessUnit;
import application.com.gamecollection.algorithm.chess.model.UnitType;

/**
 * Created by ssong25 on 8/30/17.
 */

public class BishopTest {

    private ChessBoard mChessBoard;

    @Before
    public void setUp() {
        mChessBoard = new ChessBoard();
    }

    @After
    public void tearDown() {
        mChessBoard = null;
    }

    private ChessUnit createBishop(int x, int y, boolean isWhite) {
        ChessUnit unit;
        mChessBoard.setUnit((unit = new ChessUnit(isWhite, UnitType.BISHOP)), x, y);

        return unit;
    }


    @Test
    public void testBasicMove() {
        ChessUnit bishop = createBishop(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(bishop.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 2, 2)); //to upper left
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 4, 6)); //to upper right
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 6, 4)); //to lower left
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 7, 7)); //to lower right
    }

    @Test
    public void testFailureToJumpOverTheUnit() {
        ChessUnit bishop = createBishop(5, 5, true);
        createBishop(4, 4, true);
        createBishop(4, 6, false);
        createBishop(6, 4, false);
        createBishop(6, 6, false);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(bishop.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 4, 4)); //to upper left
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 3, 7)); //to upper right
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 7, 3)); //to lower left
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 7, 7)); //to lower right
    }

    @Test
    public void testKillingEnemy() {
        ChessUnit bishop = createBishop(5, 5, true);
        createBishop(4, 4, false);
        createBishop(3, 7, false);
        createBishop(6, 4, false);
        createBishop(6, 6, false);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(bishop.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 4, 4)); //to upper left
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 3, 7)); //to upper right
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 6, 4)); //to lower left
        Assert.assertTrue(bishop.canMoveTo(mChessBoard, 5, 5, 6, 6)); //to lower right
    }

    @Test
    public void testInvalidMove() {
        ChessUnit bishop = createBishop(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(bishop.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 5, 0));
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 4, 7));
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 6, 5));
        Assert.assertFalse(bishop.canMoveTo(mChessBoard, 5, 5, 2, 5));
    }



}
