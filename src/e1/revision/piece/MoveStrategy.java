package e1.revision.piece;

import e1.Pair;

public interface MoveStrategy {
    boolean isMoveAllowed(Pair<Integer, Integer> start, Pair<Integer, Integer> finish);
}
