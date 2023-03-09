package e2.field;

import e1.Pair;

public interface Cell {
    boolean isMine();

    boolean isHitted();

    void hit();
}
