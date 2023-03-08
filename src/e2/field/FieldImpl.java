package e2.field;

import e1.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class FieldImpl implements Field {
    private final Pair<Integer, Integer> size;
    private final CellFactory cellFactory = new CellFactoryImpl();
    private final Random random = new Random();
    private final Map<Pair<Integer, Integer>, Cell> field = new HashMap<>();

    public FieldImpl(Pair<Integer, Integer> size, int mines) {
        this.size = size;
        this.initEmptyField();
        this.addMines(mines);
    }

    private void initEmptyField() {
        for (int i = 0; i < this.size.getX(); i++) {
            for (int j = 0; j < this.size.getY(); j++) {
                this.field.put(new Pair<>(i, j), this.cellFactory.empty());
            }
        }
    }

    private void addMines(int mines) {
        for (int i = 0; i < mines; i++) {
            Pair<Integer, Integer> position = this.randomEmptyPosition();
            this.field.put(position, this.cellFactory.mine());
        }
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> position = new Pair<>(this.random.nextInt(size.getX()), this.random.nextInt(size.getY()));
        return this.field.get(position).isMine() ? this.randomEmptyPosition() : position;
    }


    @Override
    public Pair<Integer, Integer> getSize() {
        return this.size;
    }

    @Override
    public int getMinesQuantity() {
        return (int) this.field.values().stream().filter(cell -> cell.isMine()).count();
    }
}
