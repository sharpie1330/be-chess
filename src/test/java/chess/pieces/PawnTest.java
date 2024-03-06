package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검정색 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final String representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(representation).isEqualTo(pawn.getRepresentation());
    }

    @Test
    @DisplayName("기본 생성자로 폰 생성 시 흰색 폰이 생성되어야 한다")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE_COLOR).isEqualTo(pawn.getColor());
        assertThat(Pawn.WHITE_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }
}