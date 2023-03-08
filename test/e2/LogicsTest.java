package e2;

import org.junit.jupiter.api.BeforeEach;

class LogicsTest {

    public static final int SIZE = 7;
    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(SIZE);
    }
}