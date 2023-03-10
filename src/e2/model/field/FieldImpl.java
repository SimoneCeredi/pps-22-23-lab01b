package e2.model.field;

import e2.Pair;
import e2.model.cell.Cell;
import e2.model.cell.factory.CellFactory;
import e2.model.cell.factory.CellFactoryImpl;

import java.util.HashMap;
import java.util.Map;

public class FieldImpl implements Field {
    private final int size;
    private final CellFactory cellFactory = new CellFactoryImpl();
    private final Map<Pair<Integer, Integer>, Cell> cells;

    public FieldImpl(int size, Map<Pair<Integer, Integer>, Cell> mines) {
        this.size = size;
        this.cells = new HashMap<>(mines);
        this.initEmptyField();
    }

    private void initEmptyField() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int finalI = i;
                int finalJ = j;
                this.cells.putIfAbsent(new Pair<>(i, j), this.cellFactory.empty(
                        (int) this.cells.entrySet().stream()
                                .filter(entry -> entry.getValue().isMine())
                                .filter(entry -> {
                                    Pair<Integer, Integer> pos = entry.getKey();
                                    return (Math.abs(finalI - pos.getX()) <= 1 && Math.abs(finalJ - pos.getY()) <= 1);
                                }).count()
                ));
            }
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Map<Pair<Integer, Integer>, Cell> getCells() {
        return this.cells;
    }

    @Override
    public int getMinesQuantity() {
        return (int) this.cells.values().stream().filter(Cell::isMine).count();
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.cells.get(pos).isMine();
    }

    @Override
    public void hit(Pair<Integer, Integer> pos) {
        this.cells.get(pos).hit();
    }

    @Override
    public boolean isHitted(Pair<Integer, Integer> pos) {
        return this.cells.get(pos).isHitted();
    }

    @Override
    public int getNearbyMines(Pair<Integer, Integer> pos) {
        return this.cells.get(pos).getNearbyMines();
    }
}
