package e2;

public interface Logics {

    int getSize();

    boolean isMine(Pair<Integer, Integer> pos);

    void hit(Pair<Integer, Integer> pos);

    boolean isHitted(Pair<Integer, Integer> pos);

    int getCellNearbyMines(Pair<Integer, Integer> pos);
}
