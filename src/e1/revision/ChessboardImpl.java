package e1.revision;

import e1.revision.piece.Piece;

public class ChessboardImpl implements Chessboard {
    private final int size;
    private final Piece pawn;
    private final Piece knight;

    public ChessboardImpl(int chessboardSize, Piece pawn, Piece knight) {
        this.size = chessboardSize;
        this.pawn = pawn;
        this.knight = knight;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Piece getPawn() {
        return this.pawn;
    }

    @Override
    public Piece getKnight() {
        return this.knight;
    }
}
