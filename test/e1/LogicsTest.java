package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LogicsTest {
    public static final int FIELD_SIZE = 5;
    public static final Pair<Integer, Integer> PAWN = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> KNIGHT = new Pair<>(1, 1);
    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(FIELD_SIZE, PAWN, KNIGHT);
    }

    @Test
    void testCantMoveOutsideField() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(FIELD_SIZE, 0));
    }

    @Test
    void testKnightExists() {
        assertTrue(() -> this.logics.hasKnight(KNIGHT.getX(), KNIGHT.getY()));
    }

    @Test
    void testPawnExists() {
        assertTrue(() -> this.logics.hasPawn(PAWN.getX(), PAWN.getY()));
    }


}