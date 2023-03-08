package e2.field;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    public static final Pair<Integer, Integer> SIZE = new Pair<>(7, 7);
    public static final int MINES = 5;
    private Field field;

    @BeforeEach
    void setUp() {
        this.field = new FieldImpl(SIZE, MINES);
    }

    @Test
    void testFieldSize() {
        assertEquals(SIZE, this.field.getSize());
    }

    @Test
    void testFieldMinesQuantity() {
        assertEquals(MINES, this.field.getMinesQuantity());
    }

}