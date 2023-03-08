package e2.field;

import e1.Pair;

public class CellImpl implements Cell {
    private final Pair<Integer, Integer> position;
    private final MineStrategy strategy;

    public CellImpl(Pair<Integer, Integer> position, MineStrategy strategy) {
        this.position = position;
        this.strategy = strategy;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean isMine() {
        return this.strategy.isMine();
    }
}
