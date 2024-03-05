package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import chess.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    private Board board;
    private int sequence;

    @BeforeEach
    void boardInit() {
        board = new Board();
        sequence = 0;
    }

    @Test
    @DisplayName("보드에 폰을 정상적으로 추가할 수 있어야 한다")
    public void create() throws Exception {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final String representation) {
        Pawn pawn = new Pawn(color, representation);
        board.add(pawn); sequence++;
        assertThat(sequence).isEqualTo(board.size());
        assertThat(pawn).isEqualTo(board.findPawn(sequence - 1));
    }

    @Test
    @DisplayName("흰색 폰과 검정색 폰이 정상적으로 초기화되어야 한다.")
    public void initialize() throws Exception {
        board.initialize();
        assertThat("♙".repeat(Board.LENGTH)).isEqualTo(board.getWhitePawnsResult());
        assertThat("♟".repeat(Board.LENGTH)).isEqualTo(board.getBlackPawnsResult());
    }
}
