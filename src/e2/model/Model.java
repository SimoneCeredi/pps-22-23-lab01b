package e2.model;

import e2.Pair;

import java.util.Set;

public interface Model {

    int getFieldSize();

    int getMinesQuantity();

    boolean isMine(Pair<Integer, Integer> pos);

    void hit(Pair<Integer, Integer> pos);

    boolean isHitted(Pair<Integer, Integer> pos);

    int getNearbyMines(Pair<Integer, Integer> pos);

    Set<Pair<Integer, Integer>> getNearbyNotHittedCellsPosition(Pair<Integer, Integer> pos);

    boolean isFlagged(Pair<Integer, Integer> pos);

    void toggleFlag(Pair<Integer, Integer> pos);
}
