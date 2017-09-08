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

public class PawnTest {

    private ChessBoard mChessBoard;

    @Before
    public void setUp() {
        mChessBoard = new ChessBoard();
    }

    @After
    public void tearDown() {
        mChessBoard = null;
    }

    private ChessUnit createPawn(int x, int y, boolean isWhite) {
        ChessUnit unit;
        mChessBoard.setUnit((unit = new ChessUnit(isWhite, UnitType.PAWN)), x, y);

        return unit;
    }


    /**
     * |   |   |   |   |
     * |   |   |[P]|   |
     * |   |   |   |   |
     *
     */
    @Test
    public void testBasicPawnMove() {
        ChessUnit pawn = createPawn(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(pawn.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check its basic move.
        Assert.assertTrue(pawn.canMoveTo(mChessBoard, 5, 5, 4, 5));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 5));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 4, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 6, 4));
        //check boundary exception.
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 8, 8));
    }


    /**
     * |   |[E]|   |   |
     * |   |   |[P]|   |
     * |   |   |   |   |
     *
     */
    @Test
    public void testPawnGetEnemy() {
        ChessUnit pawn = createPawn(5, 5, true);
        ChessUnit enemy = createPawn(4, 4, false);

        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));

        //check its status.
        Assert.assertEquals(pawn.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        Assert.assertEquals(enemy.isUnitWhite(), mChessBoard.isUnitWhite(4, 4));

        //check its basic move.
        Assert.assertTrue(pawn.canMoveTo(mChessBoard, 5, 5, 4, 5));
        Assert.assertTrue(pawn.canMoveTo(mChessBoard, 5, 5, 4, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 5));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 6, 4));

        //check boundary exception.
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 8, 8));
    }


    /**
     * |   |   |[B]|   |
     * |   |   |[P]|   |
     * |   |   |   |   |
     *
     */
    @Test
    public void testBlockingFront() {
        ChessUnit pawn = createPawn(5, 5, true);
        ChessUnit block = createPawn(4, 5, false);

        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 5));

        //check its status.
        Assert.assertEquals(pawn.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        Assert.assertEquals(block.isUnitWhite(), mChessBoard.isUnitWhite(4, 5));

        //check its basic move.
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 4, 5));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 4, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 5));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 6, 4));

        //check boundary exception.
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 8, 8));
    }

    @Test
    public void testInvalidMove() {
        ChessUnit pawn = createPawn(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(pawn.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check its basic move.
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 3, 5));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 5, 5));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 4, 4));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 6, 4));
        //check boundary exception.
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(pawn.canMoveTo(mChessBoard, 5, 5, 8, 8));
    }


}
