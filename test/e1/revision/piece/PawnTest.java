package e1.revision.piece;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    public static final Pair<Integer, Integer> LOCATION = new Pair<>(0, 0);
    private final PieceFactory pieceFactory = new PieceFactoryImpl();
    private Piece pawn;

    @BeforeEach
    void setUp() {
        this.pawn = this.pieceFactory.createPawn(LOCATION);
    }

    @Test
    void testPawnCantMove() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(LOCATION, this.pawn.move(i, j));
            }

        }
    }
}
