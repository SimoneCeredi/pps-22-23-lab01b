package e2;

public class LogicsImpl implements Logics {

    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

//        private void addMines(int mines) {
//        for (int i = 0; i < mines; i++) {
//            Pair<Integer, Integer> position = this.randomEmptyPosition();
//            this.field.put(position, this.cellFactory.mine());
//        }
//    }
//
//    private Pair<Integer, Integer> randomEmptyPosition() {
//        Pair<Integer, Integer> position = new Pair<>(this.random.nextInt(size.getX()), this.random.nextInt(size.getY()));
//        return this.field.get(position).isMine() ? this.randomEmptyPosition() : position;
//    }
}
