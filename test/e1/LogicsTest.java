package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class LogicsTest {
    public static final int FIELD_SIZE = 5;
    public static final Pair<Integer, Integer> PAWN = new Pair<>(1, 2);
    public static final Pair<Integer, Integer> KNIGHT = new Pair<>(0, 0);
    protected Logics logics;


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

    @Test
    void testKnightEatPawn() {
        assertFalse(() -> this.logics.hit(KNIGHT.getX(), KNIGHT.getY() + 1));
        assertFalse(() -> this.logics.hit(KNIGHT.getX() + 1, KNIGHT.getY() + 1));
        assertTrue(() -> this.logics.hit(KNIGHT.getX() + 1, KNIGHT.getY() + 2));

    }


}


class OldLogicsTest extends LogicsTest {
    @BeforeEach
    void setUp() {
        logics = new LogicsImpl(FIELD_SIZE, PAWN, KNIGHT);
    }
}

class NewLogicsTest extends LogicsTest {
    @BeforeEach
    void setUp() {
        logics = new e1.revision.piece.LogicsImpl(FIELD_SIZE, PAWN, KNIGHT);
    }
}