package chess.board;

import chess.pieces.Piece;
import chess.pieces.PieceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("보드에 기물들이 적절히 배치되어야 한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(32).isEqualTo(board.pieceCount());
        String blankRank = appendNewLine(Rank.BLANK_SQUARE.repeat(Rank.LENGTH));
        assertThat(
                appendNewLine("♜♞♝♛♚♝♞♜") +
                        appendNewLine("♟♟♟♟♟♟♟♟") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("♙♙♙♙♙♙♙♙") +
                        appendNewLine("♖♘♗♕♔♗♘♖"))
                .isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("보드에 있는 기물의 개수를 셀 수 있어야 한다.")
    public void countPiece() throws Exception {
        board.initialize();

        Piece blackPawn = Piece.createBlackPiece(PieceType.pawn.name());
        assertThat(8).isEqualTo(board.countPiece(blackPawn));
    }

    @Test
    @DisplayName("좌표로 보드의 기물을 조회할 수 있다")
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(Piece.createBlackPiece(PieceType.rook.name())).isEqualTo(board.findPiece("a8"));
        assertThat(Piece.createBlackPiece(PieceType.rook.name())).isEqualTo(board.findPiece("h8"));
        assertThat(Piece.createWhitePiece(PieceType.rook.name())).isEqualTo(board.findPiece("a1"));
        assertThat(Piece.createWhitePiece(PieceType.rook.name())).isEqualTo(board.findPiece("h1"));
        assertThat(Piece.createWhitePiece(PieceType.king.name())).isEqualTo(board.findPiece("e1"));
    }

    @Test
    @DisplayName("임의의 위치에 기물을 추가할 수 있어야 한다.")
    public void move() throws Exception {
        board.initializeEmpty();

        final String position = "b5";
        Piece piece = Piece.createBlackPiece(PieceType.rook.name());
        board.move(position, piece);

        assertThat(piece).isEqualTo(board.findPiece(position));
        board.print();
    }
}
