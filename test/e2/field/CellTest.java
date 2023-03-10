package e2.field;

import e2.model.cell.Cell;
import e2.model.cell.CellImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class CellTest {

    protected Cell cell;

    @Test
    void testCellStartsNotHitted() {
        assertFalse(this.cell.isHitted());
    }

    @Test
    void testCellCanGetHit() {
        this.cell.hit();
        assertTrue(this.cell.isHitted());
    }

    @Test
    void testCellStartsNotFlagged() {
        assertFalse(this.cell.isFlagged());
    }

    @Test
    void testCellCanGetFlagged() {
        this.cell.flag();
        assertTrue(this.cell.isFlagged());
    }
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