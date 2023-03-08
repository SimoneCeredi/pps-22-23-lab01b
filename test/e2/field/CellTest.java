package e2.field;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class CellTest {

    protected static final Pair<Integer, Integer> CELL_POSITION = new Pair<>(0, 0);
    protected Cell cell;


    @Test
    void testCellPosition() {
        assertEquals(CELL_POSITION, this.cell.getPosition());
    }


}

class MineTest extends CellTest {
    @BeforeEach
    void setUp() {
        super.cell = new CellImpl(CELL_POSITION, () -> true);
    }

    @Test
    void testIsCellMine() {
        assertTrue(this.cell.isMine());
    }
}

class EmptyCellTest extends CellTest {
    @BeforeEach
    void setUp() {
        super.cell = new CellImpl(CELL_POSITION, () -> false);
    }

    @Test
    void testIsCellMine() {
        assertFalse(this.cell.isMine());
    }
}