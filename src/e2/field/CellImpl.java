package e2.field;

public class CellImpl implements Cell {
    private final MineStrategy strategy;
    private boolean hitted;

    public CellImpl(MineStrategy strategy) {
        this.strategy = strategy;
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
}
