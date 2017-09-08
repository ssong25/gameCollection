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

public class KnightTest {


    private ChessBoard mChessBoard;

    @Before
    public void setUp() {
        mChessBoard = new ChessBoard();
    }

    @After
    public void tearDown() {
        mChessBoard = null;
    }

    private ChessUnit createKnight(int x, int y, boolean isWhite) {
        ChessUnit unit;
        mChessBoard.setUnit((unit = new ChessUnit(isWhite, UnitType.KNIGHT)), x, y);

        return unit;
    }

    @Test
    public void testBasicMove() {
        ChessUnit knight = createKnight(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(knight.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check basic move.
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 4, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 6));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 4, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 6));
    }

    @Test
    public void testSuccessMoveOverOtherUnits() {
        ChessUnit knight = createKnight(5, 5, true);
        //surround the target knight.
        createKnight(4, 5, true);
        createKnight(4, 4, true);
        createKnight(5, 4, true);
        createKnight(6, 4, true);
        createKnight(6, 5, true);
        createKnight(6, 6, true);
        createKnight(5, 6, true);
        createKnight(4, 6, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 6));
        //check its status.
        Assert.assertEquals(knight.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check basic move.
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 4, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 6));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 4, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 6));

    }

    @Test
    public void testFailureToMoveWhereAccompanyIs() {
        ChessUnit knight = createKnight(5, 5, true);
        //surround the target knight.
        createKnight(4, 5, true);
        createKnight(4, 4, true);
        createKnight(5, 4, true);
        createKnight(6, 4, true);
        createKnight(6, 5, true);
        createKnight(6, 6, true);
        createKnight(5, 6, true);
        createKnight(4, 6, true);
        //create accompanies.
        createKnight(4, 3, true);
        createKnight(4, 7, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 3));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 7));
        //check its status.
        Assert.assertEquals(knight.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check basic move.
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 4, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 6));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 4, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 6));

    }

    @Test
    public void testKillingEnemy() {
        ChessUnit knight = createKnight(5, 5, true);
        //surround the target knight.
        createKnight(4, 5, true);
        createKnight(4, 4, true);
        createKnight(5, 4, true);
        createKnight(6, 4, true);
        createKnight(6, 5, true);
        createKnight(6, 6, true);
        createKnight(5, 6, true);
        createKnight(4, 6, true);
        //create enemies.
        createKnight(4, 3, false);
        createKnight(4, 7, false);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 4));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 5));
        Assert.assertTrue(mChessBoard.isThereUnit(6, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(5, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 6));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 3));
        Assert.assertTrue(mChessBoard.isThereUnit(4, 7));
        //check its status.
        Assert.assertEquals(knight.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 8, 8));
        //check basic move.
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 4, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 3));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 3, 6));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 4, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 6, 7));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 4));
        Assert.assertTrue(knight.canMoveTo(mChessBoard, 5, 5, 7, 6));
    }


    @Test
    public void testInvalidMove() {
        ChessUnit knight = createKnight(5, 5, true);
        //check its existence on the board.
        Assert.assertTrue(mChessBoard.isThereUnit(5, 5));
        //check its status.
        Assert.assertEquals(knight.isUnitWhite(), mChessBoard.isUnitWhite(5, 5));
        //check boundary exception.
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, -1, -1));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 8, 8));

        //check invalid move.
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 5, 4));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 4, 4));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 6, 4));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 6, 6));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 6, 5));
        Assert.assertFalse(knight.canMoveTo(mChessBoard, 5, 5, 5, 6));
    }

}
