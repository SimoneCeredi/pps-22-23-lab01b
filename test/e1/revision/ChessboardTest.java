package e1.revision;

import e1.Pair;
import e1.revision.piece.Piece;
import e1.revision.piece.PieceFactory;
import e1.revision.piece.PieceFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessboardTest {

    public static final int CHESSBOARD_SIZE = 5;
    private final PieceFactory factory = new PieceFactoryImpl();
    private final Piece pawn = factory.createPawn(new Pair<>(0, 0));
    private final Piece knight = factory.createKnight(new Pair<>(1, 1));
    private Chessboard chessboard;

    @BeforeEach
    void setUp() {
        this.chessboard = new ChessboardImpl(CHESSBOARD_SIZE, pawn,
                knight);
    }

    @Test
    void testChessboardSize() {
        assertEquals(CHESSBOARD_SIZE, this.chessboard.getSize());
    }

    @Test
    void testCanGetPawn() {
        assertEquals(this.pawn, this.chessboard.getPawn());
    }

    @Test
    void testCanGetKnight() {
        assertEquals(this.knight, this.chessboard.getKnight());
    }
}