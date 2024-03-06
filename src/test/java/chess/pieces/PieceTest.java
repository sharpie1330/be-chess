package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("각 체스 기물마다 흰색과 검정색 기물이 생성되어야 한다")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Representation.pawn.getRepresentation_white());
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Representation.pawn.getRepresentation_black());

        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Representation.bishop.getRepresentation_white());
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Representation.bishop.getRepresentation_black());

        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Representation.rook.getRepresentation_white());
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Representation.rook.getRepresentation_black());

        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Representation.knight.getRepresentation_white());
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Representation.knight.getRepresentation_black());

        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Representation.queen.getRepresentation_white());
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Representation.queen.getRepresentation_black());

        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Representation.king.getRepresentation_white());
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Representation.king.getRepresentation_black());
    }

    private void verifyPiece(final Piece piece, final String color, final String representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }
}