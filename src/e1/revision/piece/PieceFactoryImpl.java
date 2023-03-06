package e1.revision.piece;

import e1.Pair;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public Piece createKnight(Pair<Integer, Integer> location) {
        return new PieceImpl(location, (start, finish) -> {
            int x = Math.abs(finish.getX() - start.getX());
            int y = Math.abs(finish.getY() - start.getY());
            return x != 0 && y != 0 && x + y == 3;
        });
    }
}
