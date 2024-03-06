package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import chess.pieces.Piece;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    private Board board;
    private int sequence;

    @BeforeEach
    void boardInit() {
        board = new Board();
        sequence = 0;
    }
}
