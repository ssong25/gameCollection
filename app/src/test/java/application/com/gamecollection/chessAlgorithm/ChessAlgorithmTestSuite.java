package application.com.gamecollection.chessAlgorithm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import application.com.gamecollection.algorithm.chess.model.ChessBoard;

/**
 * Created by ssong25 on 9/13/17.
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({
        BishopTest.class, ChessBoardTest.class,
        KingTest.class, KnightTest.class,
        PawnTest.class, QueenTest.class,
        RookTest.class, ChessBoardTest.class
})
public class ChessAlgorithmTestSuite {

}
