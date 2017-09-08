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

public class KingTest {

    private ChessBoard mChessBoard;

    @Before
    public void setUp() {
        mChessBoard = new ChessBoard();
    }

    @After
    public void tearDown() {
        mChessBoard = null;
    }

    private ChessUnit createKing(int x, int y, boolean isWhite) {
        ChessUnit unit;
        mChessBoard.setUnit((unit = new ChessUnit(isWhite, UnitType.KING)), x, y);

        return unit;
    }


    /**
     * |   |   |   |   |
     * |   |   |[K]|   |
     * |   |   |   |   |
     *
     */
    @Test
    public void testBasicMove() {
        ChessUnit king = createKing(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(king.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 5, 4)); //to left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 5, 6)); //to right
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 5)); //to up
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 5)); //to down
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 4)); //to upper left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 6)); //to upper right
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 4)); //to lower left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 6)); //to lower right

    }

    /**
     * |   |   |[P]|   |
     * |   |   |[K]|   |
     * |   |   |   |   |
     *
     */
    @Test
    public void testBlockingAccompany() {
        ChessUnit king = createKing(5, 5, true);
        ChessUnit block = createKing(4, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4,5));
        //check its status.
        Assert.assertEquals(king.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check move failure due to accompany.
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 4, 5));
        //check basic move.
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 5, 4)); //to left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 5, 6)); //to right
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 5)); //to down
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 4)); //to upper left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 6)); //to upper right
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 4)); //to lower left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 6)); //to lower right
    }

    /**
     * |   |   |[E]|   |
     * |   |   |[K]|   |
     * |   |   |   |   |
     *
     */
    @Test
    public void testKillingEnemy() {
        ChessUnit king = createKing(5, 5, true);
        ChessUnit block = createKing(4, 5, false);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4,5));
        //check its status.
        Assert.assertEquals(king.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check killing enemy.
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 5));
        //check basic move.
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 5, 4)); //to left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 5, 6)); //to right
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 5)); //to down
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 4)); //to upper left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 4, 6)); //to upper right
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 4)); //to lower left
        Assert.assertTrue(king.canMoveTo(mChessBoard, 5, 5, 6, 6)); //to lower right

    }

    @Test
    public void testInvalidMove() {
        ChessUnit king = createKing(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(king.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check its basic move.
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 5, 0));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 7, 7));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 3, 4));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 7, 0));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 0, 0));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 3, 6));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 6, 3));
        Assert.assertFalse(king.canMoveTo(mChessBoard, 5, 5, 7, 6));
    }



}
