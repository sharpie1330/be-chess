package chess;

import chess.pieces.Pieces;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        verifyPawn(Pieces.WHITE_COLOR);
        verifyPawn(Pieces.BLACK_COLOR);
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        board.add(pawn); sequence++;
        assertEquals(sequence, board.size());
        assertEquals(pawn, board.findPawn(sequence - 1));
    }

    @Test
    @DisplayName("보드가 정상적으로 초기화되어야 한다.")
    public void boardInitCheck() {
        final String BOARD_INIT =
        """
        ▯▯▯▯▯▯▯▯
        ♟♟♟♟♟♟♟♟
        ▯▯▯▯▯▯▯▯
        ▯▯▯▯▯▯▯▯
        ▯▯▯▯▯▯▯▯
        ▯▯▯▯▯▯▯▯
        ♙♙♙♙♙♙♙♙
        ▯▯▯▯▯▯▯▯""";

        board.boardInit();
        String boardString = board.boardPrint();

        assertThat(boardString).isEqualTo(BOARD_INIT);
    }
}
