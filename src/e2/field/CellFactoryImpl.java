package e2.field;

public class CellFactoryImpl implements CellFactory {
    @Override
    public Cell mine() {
        return new CellImpl(() -> true);
    }

    @Override
    public Cell empty(int nearbyMines) {
        return new CellImpl(() -> false, nearbyMines);
    }
}
