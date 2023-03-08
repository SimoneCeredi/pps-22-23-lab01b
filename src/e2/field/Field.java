package e2.field;

import e2.Pair;

public interface Field {
    int getSize();

    int getMinesQuantity();

    boolean isMine(Pair<Integer, Integer> pos);
}
