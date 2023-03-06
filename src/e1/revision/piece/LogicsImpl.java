package e1.revision.piece;

import e1.Logics;
import e1.Pair;

public class LogicsImpl implements Logics {

    private final PieceFactory pieceFactory = new PieceFactoryImpl();
    private final Piece pawn;
    private final Piece knight;
    private final int size;

    public LogicsImpl(int fieldSize, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight) {
        this.size = fieldSize;
        this.pawn = this.pieceFactory.createPawn(pawn);
        this.knight = this.pieceFactory.createKnight(knight);
    }

    @Override
    public boolean hit(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.pawn.getLocation().equals(this.knight.move(row, col));
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.getLocation().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.getLocation().equals(new Pair<>(row, col));
    }
}
