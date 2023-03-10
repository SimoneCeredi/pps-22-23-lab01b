package e2;

import e2.model.cell.Cell;
import e2.model.cell.factory.CellFactory;
import e2.model.cell.factory.CellFactoryImpl;
import e2.model.field.Field;
import e2.model.field.FieldImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LogicsImpl implements Logics {

    private static final int MINES_QUANTITY = 10;
    private final Field field;

    public LogicsImpl(int size) {
        this.field = new FieldImpl(size, this.createMines(size, MINES_QUANTITY));
    }

    private Map<Pair<Integer, Integer>, Cell> createMines(int size, int minesQuantity) {
        Map<Pair<Integer, Integer>, Cell> mines = new HashMap<>();
        CellFactory cellFactory = new CellFactoryImpl();

        for (int i = 0; i < minesQuantity; i++) {
            Pair<Integer, Integer> position = this.randomEmptyPosition(size, mines);
            mines.put(position, cellFactory.mine());
        }
        return mines;
    }

    private Pair<Integer, Integer> randomEmptyPosition(int size, Map<Pair<Integer, Integer>, Cell> mines) {
        Random random = new Random();
        Pair<Integer, Integer> position = new Pair<>(random.nextInt(size), random.nextInt(size));
        return mines.get(position) != null ? this.randomEmptyPosition(size, mines) : position;
    }

    @Override
    public int getSize() {
        return this.field.getSize();
    }

    @Override
    public boolean isMine(e2.Pair<Integer, Integer> pos) {
        return this.field.isMine(pos);
    }

    @Override
    public void hit(Pair<Integer, Integer> pos) {
        this.field.hit(pos);
    }

    @Override
    public boolean isHitted(Pair<Integer, Integer> pos) {
        return this.field.isHitted(pos);
    }

    @Override
    public int getCellNearbyMines(Pair<Integer, Integer> pos) {
        return this.field.getNearbyMines(pos);
    }


}
