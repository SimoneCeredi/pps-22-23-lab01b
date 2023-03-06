package e1.revision.piece;

import e1.Pair;

/**
 * Represents a chess piece
 */
public interface Piece {
    /**
     * Tries to move the piece to the given location
     *
     * @param row
     * @param column
     * @return the new location of the piece
     */
    Pair<Integer, Integer> move(int row, int column);
}
