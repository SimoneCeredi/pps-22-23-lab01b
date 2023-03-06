package e1.revision.piece;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightTest {

    public static final Pair<Integer, Integer> LOCATION = new Pair<>(0, 0);
    private final PieceFactory pieceFactory = new PieceFactoryImpl();
    private Piece knight;

    @BeforeEach
    void setUp() {
        this.knight = this.pieceFactory.createKnight(LOCATION);
    }

    @Test
    void testKnightIllegalMove() {
        assertEquals(LOCATION, this.knight.move(LOCATION.getX() + 1, LOCATION.getY() + 1));
    }

    @Test
    void testKnightLegalMove() {
        Pair<Integer, Integer> newLocation = new Pair<>(LOCATION.getX() + 1, LOCATION.getY() + 2);
        assertEquals(newLocation, this.knight.move(newLocation.getX(), newLocation.getY()));
    }
}