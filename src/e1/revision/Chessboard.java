package e1.revision;

import e1.revision.piece.Piece;

/**
 * Represents a simple chessboard
 */
public interface Chessboard {

    /**
     * Returns the chessboard size
     *
     * @return the chessboard size
     */
    int getSize();

    /**
     * Returns the pawn
     *
     * @return the pawn
     */
    Piece getPawn();

    /**
     * Returns the knight
     *
     * @return the knight
     */
    Piece getKnight();

}
