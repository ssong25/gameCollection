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

public class QueenTest {

    private ChessBoard mChessBoard;

    @Before
    public void setUp() {
        mChessBoard = new ChessBoard();
    }

    @After
    public void tearDown() {
        mChessBoard = null;
    }

    private ChessUnit createQueen(int x, int y, boolean isWhite) {
        ChessUnit unit;
        mChessBoard.setUnit((unit = new ChessUnit(isWhite, UnitType.QUEEN)), x, y);

        return unit;
    }

    @Test
    public void testBasicMove() {
        ChessUnit queen = createQueen(4, 4, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));
        //check its status.
        Assert.assertEquals(queen.isUnitWhite(), mChessBoard.isUnitWhite(4, 4));
        //check boundary exception.
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, -1, -1));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 8, 8));
        //check its basic move.
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 3, 3));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 3, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 3, 5));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 4, 3));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 4, 5));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 5, 3));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 5, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 5, 5));

        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 2, 2));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 2, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 2, 6));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 4, 2));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 4, 6));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 6, 2));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 6, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 6, 6));
    }

    @Test
    public void testFailureToJumpOvertheUnit() {
        ChessUnit queen = createQueen(4, 4, true);
        createQueen(3, 3, true);
        createQueen(4, 5, false);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(3, 3));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 5));
        //check its status.
        Assert.assertEquals(queen.isUnitWhite(), mChessBoard.isUnitWhite(4, 4));
        Assert.assertEquals(queen.isUnitWhite(), mChessBoard.isUnitWhite(3, 3));
        Assert.assertNotSame(queen.isUnitWhite(), mChessBoard.isUnitWhite(4, 5));
        //check boundary exception.
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, -1, -1));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 8, 8));
        //check its basic move.
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 3, 3));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 3, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 3, 5));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 4, 3));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 5, 3));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 5, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 5, 5));

        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 2, 2));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 2, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 2, 6));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 4, 2));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 4, 6));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 6, 2));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 6, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 6, 6));
    }

    @Test
    public void testKillingEnemy() {
        ChessUnit queen = createQueen(4, 4, true);
        createQueen(2, 4, false);
        createQueen(5, 5, false);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));
        //check its status.
        Assert.assertEquals(queen.isUnitWhite(), mChessBoard.isUnitWhite(4, 4));
        //check boundary exception.
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, -1, -1));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 8, 8));
        //check its basic move.
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 2, 4));
        Assert.assertTrue(queen.canMoveTo(mChessBoard, 4, 4, 5, 5));
    }

    @Test
    public void testInvalidMove() {
        ChessUnit queen = createQueen(4, 4, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));
        //check its status.
        Assert.assertEquals(queen.isUnitWhite(), mChessBoard.isUnitWhite(4, 4));
        //check boundary exception.
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, -1, -1));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 8, 8));
        //check its basic move.
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 2, 3));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 2, 5));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 3, 2));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 3, 6));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 5, 2));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 5, 6));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 6, 3));
        Assert.assertFalse(queen.canMoveTo(mChessBoard, 4, 4, 6, 5));
    }



}
