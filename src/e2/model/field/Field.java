package e2.model.field;

import e2.Pair;
import e2.model.cell.Cell;

import java.util.Map;

public interface Field {
    int getSize();

    Map<Pair<Integer, Integer>, Cell> getCells();

    int getMinesQuantity();

    boolean isMine(Pair<Integer, Integer> pos);

    void hit(Pair<Integer, Integer> pos);

    boolean isHitted(Pair<Integer, Integer> pos);

    int getNearbyMines(Pair<Integer, Integer> pos);
}
