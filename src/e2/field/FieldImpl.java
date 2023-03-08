package e2.field;

import e1.Pair;

import java.util.HashMap;
import java.util.Map;

public class FieldImpl implements Field {
    private final Pair<Integer, Integer> size;
    private final CellFactory cellFactory = new CellFactoryImpl();
    private final Map<Pair<Integer, Integer>, Cell> field;

    public FieldImpl(Pair<Integer, Integer> size, Map<Pair<Integer, Integer>, Cell> mines) {
        this.size = size;
        this.field = new HashMap<>(mines);
        this.initEmptyField();
    }

    private void initEmptyField() {
        for (int i = 0; i < this.size.getX(); i++) {
            for (int j = 0; j < this.size.getY(); j++) {
                this.field.putIfAbsent(new Pair<>(i, j), this.cellFactory.empty());
            }
        }
    }

    @Override
    public Pair<Integer, Integer> getSize() {
        return this.size;
    }

    @Override
    public int getMinesQuantity() {
        return (int) this.field.values().stream().filter(Cell::isMine).count();
    }
}
