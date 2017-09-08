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

public class RookTest {


    private ChessBoard mChessBoard;

    @Before
    public void setUp() {
        mChessBoard = new ChessBoard();
    }

    @After
    public void tearDown() {
        mChessBoard = null;
    }

    private ChessUnit createRook(int x, int y, boolean isWhite) {
        ChessUnit unit;
        mChessBoard.setUnit((unit = new ChessUnit(isWhite, UnitType.ROOK)), x, y);

        return unit;
    }

    @Test
    public void testBasicMove() {
        ChessUnit rook = createRook(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(rook.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 5, 0)); //to left
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 5, 7)); //to right
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 0, 5)); //to up
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 7, 5)); //to bottom
    }


    @Test
    public void testFailureToJumpOverUnit() {
        ChessUnit rook = createRook(5, 5, true);
        createRook(5, 2, false);
        createRook(5, 6, false);
        createRook(3, 5, false);
        createRook(7, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 2));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(3, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(7, 5));
        //check its status.
        Assert.assertEquals(rook.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 5, 0)); //to left
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 5, 7)); //to right
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 0, 5)); //to up
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 7, 5)); //to bottom
    }

    @Test
    public void testKillingEnemy() {
        ChessUnit rook = createRook(5, 5, true);
        createRook(5, 2, false);
        createRook(5, 6, false);
        createRook(3, 5, false);
        createRook(7, 5, false);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 2));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(3, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(7, 5));
        //check its status.
        Assert.assertEquals(rook.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 5, 2)); //to left
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 5, 6)); //to right
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 3, 5)); //to up
        Assert.assertTrue(rook.canMoveTo(mChessBoard, 5, 5, 7, 5)); //to bottom
    }

    @Test
    public void testInvalidMove() {
        ChessUnit rook = createRook(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(rook.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 4, 0));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 3, 3));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 3, 6));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 7, 3));
        Assert.assertFalse(rook.canMoveTo(mChessBoard, 5, 5, 7, 7));
    }


}
