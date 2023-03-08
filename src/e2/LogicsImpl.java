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
}
