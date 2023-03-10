package e2.model.cell;

import e2.model.cell.strategy.MineStrategy;

public class CellImpl implements Cell {
    private final MineStrategy strategy;
    private final int nearbyMines;
    private boolean hitted;
    private boolean flagged;

    public CellImpl(MineStrategy strategy, int nearbyMines) {
        this.strategy = strategy;
        this.nearbyMines = nearbyMines;
    }

    public CellImpl(MineStrategy strategy) {
        this.strategy = strategy;
        this.nearbyMines = 0;
    }

    @Override
    public boolean isMine() {
        return this.strategy.isMine();
    }

    @Override
    public boolean isHitted() {
        return this.hitted;
    }

    @Override
    public void hit() {
        this.hitted = true;
    }

    @Override
    public int getNearbyMines() {
        return this.nearbyMines;
    }

    @Override
    public boolean isFlagged() {
        return this.flagged;
    }

    @Override
    public void flag() {
        this.flagged = true;
    }
}
