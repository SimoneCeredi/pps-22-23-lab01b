package e2.model.cell.factory;

import e2.model.cell.Cell;
import e2.model.cell.CellImpl;

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
