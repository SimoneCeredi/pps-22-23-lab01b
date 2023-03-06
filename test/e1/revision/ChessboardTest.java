package e1.revision;

import org.junit.jupiter.api.BeforeEach;

class ChessboardTest {

    public static final int CHESSBOARD_SIZE = 5;
    private Chessboard chessboard;

    @BeforeEach
    void setUp() {
        this.chessboard = new ChessboardImpl(CHESSBOARD_SIZE);
    }
}