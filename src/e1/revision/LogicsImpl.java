package e1.revision;

import e1.Logics;
import e1.Pair;
import e1.revision.piece.PieceFactory;
import e1.revision.piece.PieceFactoryImpl;

import java.util.Random;

public class LogicsImpl implements Logics {

    private final Chessboard chessboard;
    private final int size;
    private final Random random = new Random();
    private final PieceFactory pieceFactory = new PieceFactoryImpl();

    public LogicsImpl(int fieldSize, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight) {
        this.size = fieldSize;
        this.chessboard = new ChessboardImpl(size, this.pieceFactory.createPawn(pawn), this.pieceFactory.createKnight(knight));
    }

    public LogicsImpl(int size) {
        this.size = size;
        this.chessboard = new ChessboardImpl(size, this.pieceFactory.createPawn(randomEmptyPosition()),
                this.pieceFactory.createKnight(randomEmptyPosition()));
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.chessboard.getPawn() != null && this.chessboard.getPawn().getLocation().equals(pos) ?
                randomEmptyPosition() : pos;
    }

    @Override
    public boolean hit(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.chessboard.getPawn().getLocation().equals(this.chessboard.getKnight().move(row, col));
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.chessboard.getKnight().getLocation().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.chessboard.getPawn().getLocation().equals(new Pair<>(row, col));
    }
}
