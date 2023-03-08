package e2.field;

import e1.Pair;

public interface Cell {
    Pair<Integer, Integer> getPosition();

    boolean isMine();
}
