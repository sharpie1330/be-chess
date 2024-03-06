package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

public class Board {
    public static final String BLANK_SPACE = "▯";
    public static final int LENGTH = 8;

    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    private List<Piece> pieces;

    public Board() {

    }

    public void initialize() {
    }

    public void print() {
        StringBuilder boardString = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            String line;
            if (i == 1) {
                line = getBlackPawnsResult();
            } else if (i == 6) {
                line = getWhitePawnsResult();
            } else {
                line = BLANK_SPACE.repeat(LENGTH);
            }
            boardString.append(appendNewLine(line));
        }

        boardString.deleteCharAt(boardString.length() - 1);

        System.out.println(boardString);
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
    }

    public String getWhitePawnsResult() {
        return whitePieces.stream().map(Piece::getRepresentation).reduce("", (x, y) -> x + y);
    }

    public String getBlackPawnsResult() {
        return blackPieces.stream().map(Piece::getRepresentation).reduce("", (x, y) -> x + y);
    }
}
