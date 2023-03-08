package e2.field;

import e1.Pair;

public class CellImpl implements Cell {
    private final MineStrategy strategy;

    public CellImpl(MineStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean isMine() {
        return this.strategy.isMine();
    }
}
