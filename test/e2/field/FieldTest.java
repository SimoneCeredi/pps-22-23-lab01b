package e2.field;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    public static final Pair<Integer, Integer> SIZE = new Pair<>(7, 7);
    public static final int MINES_QUANTITY = 5;

    private Field field;

    @BeforeEach
    void setUp() {
        this.field = new FieldImpl(SIZE, this.createMines(MINES_QUANTITY));
    }

    private Map<Pair<Integer, Integer>, Cell> createMines(int minesQuantity) {
        Map<Pair<Integer, Integer>, Cell> mines = new HashMap<>();
        CellFactory cellFactory = new CellFactoryImpl();

        for (int i = 0; i < minesQuantity; i++) {
            Pair<Integer, Integer> position = this.randomEmptyPosition(mines);
            mines.put(position, cellFactory.mine());
        }
        return mines;
    }

    private Pair<Integer, Integer> randomEmptyPosition(Map<Pair<Integer, Integer>, Cell> mines) {
        Random random = new Random();
        Pair<Integer, Integer> position = new Pair<>(random.nextInt(SIZE.getX()), random.nextInt(SIZE.getY()));
        return mines.get(position) != null ? this.randomEmptyPosition(mines) : position;
    }

    @Test
    void testFieldSize() {
        assertEquals(SIZE, this.field.getSize());
    }

    @Test
    void testFieldMinesQuantity() {
        assertEquals(MINES_QUANTITY, this.field.getMinesQuantity());
    }

}