package e2.field;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private static final Pair<Integer, Integer> CELL_POSITION = new Pair<>(0, 0);
    private Cell cell;

    @BeforeEach
    void setUp() {
        this.cell = new CellImpl(CELL_POSITION);
    }

    @Test
    void testCellPosition() {
        assertEquals(CELL_POSITION, this.cell.getPosition());
    }
}