package e2.logics;

import e2.Pair;

public interface Logics {

    int getSize();

    boolean isMine(Pair<Integer, Integer> pos);

    void hit(Pair<Integer, Integer> pos);

    boolean isHitted(Pair<Integer, Integer> pos);

    int getCellNearbyMines(Pair<Integer, Integer> pos);

    boolean isFlagged(Pair<Integer, Integer> pos);

    void toggleFlag(Pair<Integer, Integer> pos);

    boolean isThereVictory();
}
