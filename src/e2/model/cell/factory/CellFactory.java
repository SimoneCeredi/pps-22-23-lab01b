package e2.model.cell.factory;

import e2.model.cell.Cell;

public interface CellFactory {
    Cell mine();

    Cell empty(int nearbyMines);
}
