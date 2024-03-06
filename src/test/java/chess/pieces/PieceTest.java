package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰과 검정색 폰이 생성되어야 한다")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Representation.pawn.getRepresentation_white());
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Representation.pawn.getRepresentation_black());
    }

    private void verifyPiece(final Piece piece, final String color, final String representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }
}