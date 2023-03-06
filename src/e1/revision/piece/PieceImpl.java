package e1.revision.piece;

import e1.Pair;

public class PieceImpl implements Piece {

    private final MoveStrategy strategy;
    private Pair<Integer, Integer> location;

    public PieceImpl(Pair<Integer, Integer> location, MoveStrategy strategy) {
        this.location = location;
        this.strategy = strategy;
    }


    @Override
    public Pair<Integer, Integer> move(int row, int column) {

        Pair<Integer, Integer> newLocation = new Pair<>(row, column);
        if (strategy.isMoveAllowed(this.location, newLocation)) {
            this.location = newLocation;
        }
        return this.location;
    }
}
