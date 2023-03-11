package e2.model.cell;

public interface Cell {
    boolean isMine();

    boolean isHitted();

    void hit();

    int getNearbyMines();

    boolean isFlagged();

    void toggleFlag();
}
