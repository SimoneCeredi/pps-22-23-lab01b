package e2.field;

public class FieldImpl implements Field {
    private final int size;

    public FieldImpl(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
