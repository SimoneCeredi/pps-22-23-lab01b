package e1.revision.piece;

import e1.Pair;

public interface PieceFactory {

    Piece createKnight(Pair<Integer, Integer> location);

    Piece createPawn(Pair<Integer, Integer> location);
}
