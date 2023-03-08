package e2;

import e1.Pair;
import e2.field.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LogicsImpl implements Logics {

    private static final int MINES_QUANTITY = 10;
    private final Field field;

    public LogicsImpl(int size) {
        this.field = new FieldImpl(size, this.createMines(size, MINES_QUANTITY));
    }

    private Map<e1.Pair<Integer, Integer>, Cell> createMines(int size, int minesQuantity) {
        Map<e1.Pair<Integer, Integer>, Cell> mines = new HashMap<>();
        CellFactory cellFactory = new CellFactoryImpl();

        for (int i = 0; i < minesQuantity; i++) {
            e1.Pair<Integer, Integer> position = this.randomEmptyPosition(size, mines);
            mines.put(position, cellFactory.mine());
        }
        return mines;
    }

    private e1.Pair<Integer, Integer> randomEmptyPosition(int size, Map<e1.Pair<Integer, Integer>, Cell> mines) {
        Random random = new Random();
        e1.Pair<Integer, Integer> position = new Pair<>(random.nextInt(size), random.nextInt(size));
        return mines.get(position) != null ? this.randomEmptyPosition(size, mines) : position;
    }

    @Override
    public int getSize() {
        return this.field.getSize();
    }


}
