package e2.field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    public static final int SIZE = 7;
    private Field field;

    @BeforeEach
    void setUp() {
        this.field = new FieldImpl(SIZE);
    }

    @Test
    void testFieldSize() {
        assertEquals(SIZE, this.field.getSize());
    }

}