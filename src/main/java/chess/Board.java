package chess;

import chess.pieces.Pawn;
import chess.pieces.Pieces;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final String BLANK_SPACE = "▯";
    public static final int LENGTH = 8;

    private final List<List<Pawn>> board;
    private List<Pawn> pawns;

    public Board() {
        board = new ArrayList<>();
    }

    public void initialize() {
        for (int i = 0; i < LENGTH; i++) {
            pawns = new ArrayList<>();
            for (int j = 0; j < LENGTH; j++) {
                if (i == 1) {
                    add(new Pawn());
                } else if (i == 6) {
                    add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
                }
            }
            board.add(pawns);
        }
    }

    public String print() {
        StringBuilder boardString = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                boardString.append(board.get(i).get(j));
            }
            boardString.append("\n");
        }

        boardString.replace(boardString.length() - 1, boardString.length(), "");

        return boardString.toString();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public String getWhitePawnsResult() {
        StringBuilder whitePawnResult = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            whitePawnResult.append(board.get(1).get(i).getRepresentation());
        }

        return whitePawnResult.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder blackPawnResult = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            blackPawnResult.append(board.get(6).get(i).getRepresentation());
        }

        return blackPawnResult.toString();
    }
}
