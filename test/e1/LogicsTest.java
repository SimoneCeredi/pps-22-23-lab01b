package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LogicsTest {
    public static final int FIELD_SIZE = 5;
    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(FIELD_SIZE);
    }

    @Test
    void testCantMoveOutsideField() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(FIELD_SIZE, 0));
    }


}