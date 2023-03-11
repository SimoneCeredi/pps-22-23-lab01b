package e2.logics;

import e2.Pair;
import e2.model.Model;
import e2.model.ModelImpl;
import e2.model.cell.Cell;
import e2.model.cell.factory.CellFactory;
import e2.model.cell.factory.CellFactoryImpl;
import e2.model.field.FieldImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics {

    private static final int MINES_QUANTITY = 10;
    private final Model model;

    public LogicsImpl(int size) {
        this.model = new ModelImpl(new FieldImpl(size, this.createMines(size, MINES_QUANTITY)));
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
        return this.model.getFieldSize();
    }

    @Override
    public boolean isMine(e2.Pair<Integer, Integer> pos) {
        return this.model.isMine(pos);
    }

    @Override
    public void hit(Pair<Integer, Integer> pos) {
        if (!this.isMine(pos)) {
            this.model.hit(pos);
            if (this.model.getNearbyMines(pos) == 0) {
                Set<Pair<Integer, Integer>> cells = this.model.getNearbyNotHittedCellsPosition(pos);
                cells.forEach(this::hit);
            }
        }
    }

    @Override
    public boolean isHitted(Pair<Integer, Integer> pos) {
        return this.model.isHitted(pos);
    }

    @Override
    public int getCellNearbyMines(Pair<Integer, Integer> pos) {
        return this.model.getNearbyMines(pos);
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> pos) {
        return this.model.isFlagged(pos);
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> pos) {
        this.model.toggleFlag(pos);
    }

    @Override
    public boolean isThereVictory() {
        return this.model.isThereVictory();
    }


}
