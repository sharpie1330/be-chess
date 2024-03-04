package test.mission1;

import mission.mission1.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검정색 폰이 생성되어야 한다")
    void create() {
        Pawn pawnWhite = new Pawn("white");
        assertThat(pawnWhite.getColor()).isEqualTo("white");
        Pawn pawnBlack = new Pawn("black");
        assertThat(pawnBlack.getColor()).isEqualTo("black");
    }
}