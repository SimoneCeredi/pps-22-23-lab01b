package e2.field;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class CellTest {

    protected Cell cell;


}

class MineTest extends CellTest {
    @BeforeEach
    void setUp() {
        super.cell = new CellImpl(() -> true);
    }

    @Test
    void testIsCellMine() {
        assertTrue(this.cell.isMine());
    }
}

class EmptyCellTest extends CellTest {
    @BeforeEach
    void setUp() {
        super.cell = new CellImpl(() -> false);
    }

    @Test
    void testIsCellMine() {
        assertFalse(this.cell.isMine());
    }
}