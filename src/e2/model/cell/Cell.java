package e2.model.cell;

import e1.Pair;

public interface Cell {
    boolean isMine();

    boolean isHitted();

    void hit();

    int getNearbyMines();
}
