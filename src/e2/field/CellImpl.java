package e2.field;

import e1.Pair;

public class CellImpl implements Cell {
    private final Pair<Integer, Integer> position;

    public CellImpl(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
