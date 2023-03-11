package e2.model;

import e2.Pair;
import e2.model.cell.Cell;
import e2.model.field.Field;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelImpl implements Model {

    private final Field field;

    public ModelImpl(Field field) {
        this.field = field;
    }

    @Override
    public int getFieldSize() {
        return this.field.getSize();
    }

    @Override
    public int getMinesQuantity() {
        return (int) this.field.getCells().values().stream().filter(Cell::isMine).count();
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> pos) {
        return this.field.getCells().get(pos).isMine();
    }

    @Override
    public void hit(Pair<Integer, Integer> pos) {
        this.field.getCells().get(pos).hit();
    }

    @Override
    public boolean isHitted(Pair<Integer, Integer> pos) {
        return this.field.getCells().get(pos).isHitted();
    }

    @Override
    public int getNearbyMines(Pair<Integer, Integer> pos) {
        return this.field.getCells().get(pos).getNearbyMines();
    }

    @Override
    public Set<Pair<Integer, Integer>> getNearbyNotHittedCellsPosition(Pair<Integer, Integer> pos) {
        return this.field.getCells().entrySet().stream()
                .filter(entry -> Math.abs(pos.getX() - entry.getKey().getX()) <= 1
                        && Math.abs(pos.getY() - entry.getKey().getY()) <= 1)
                .filter(entry -> !entry.getValue().isHitted())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> pos) {
        return this.field.getCells().get(pos).isFlagged();
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> pos) {
        this.field.getCells().get(pos).toggleFlag();
    }

    @Override
    public boolean isThereVictory() {
        return this.field.getCells().values().stream()
                .filter(cell -> !cell.isHitted()).allMatch(Cell::isMine);
    }
}
