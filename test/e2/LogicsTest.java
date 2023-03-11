package e2;

import e2.logics.Logics;
import e2.logics.LogicsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicsTest {

    public static final int SIZE = 7;
    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(SIZE);
    }

    @Test
    void testLogicsIsCorrectSize() {
        assertEquals(SIZE, this.logics.getSize());
    }
}