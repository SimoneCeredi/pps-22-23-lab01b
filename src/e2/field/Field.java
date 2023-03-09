package e2.field;

import e2.Pair;

public interface Field {
    int getSize();

    int getMinesQuantity();

    boolean isMine(Pair<Integer, Integer> pos);

    void hit(Pair<Integer, Integer> pos);

    boolean isHitted(Pair<Integer, Integer> pos);

    int getNearbyMines(Pair<Integer, Integer> pos);
}
