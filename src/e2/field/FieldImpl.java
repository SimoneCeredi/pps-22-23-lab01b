package e2.field;

import e2.Pair;

import java.util.HashMap;
import java.util.Map;

public class FieldImpl implements Field {
    private final int size;
    private final CellFactory cellFactory = new CellFactoryImpl();
    private final Map<Pair<Integer, Integer>, Cell> field;

    public FieldImpl(int size, Map<Pair<Integer, Integer>, Cell> mines) {
        this.size = size;
        this.field = new HashMap<>(mines);
        this.initEmptyField();
    }

    private void initEmptyField() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int finalI = i;
                int finalJ = j;
                this.field.putIfAbsent(new Pair<>(i, j), this.cellFactory.empty(
                        (int) this.field.entrySet().stream()
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
    public int getMinesQuantity() {
        return (int) this.field.values().stream().filter(Cell::isMine).count();
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.field.get(pos).isMine();
    }

    @Override
    public void hit(Pair<Integer, Integer> pos) {
        this.field.get(pos).hit();
    }

    @Override
    public boolean isHitted(Pair<Integer, Integer> pos) {
        return this.field.get(pos).isHitted();
    }

    @Override
    public int getNearbyMines(Pair<Integer, Integer> pos) {
        return this.field.get(pos).getNearbyMines();
    }
}
