package chess;

import chess.pieces.Pawn;
import chess.pieces.Pieces;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final String BLANK_SPACE = "▯";
    private static final int LENGTH = 8;
    private final String[][] board;
    private final List<Pawn> pawns;

    public Board() {
        board = new String[LENGTH][LENGTH];
        pawns = new ArrayList<>();
    }

    public void boardInit() {
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (i == 1) {
                    board[i][j] = Pieces.BLACK_PAWN.getIcon();
                } else if (i == 6) {
                    board[i][j] = Pieces.WHITE_PAWN.getIcon();
                } else {
                    board[i][j] = BLANK_SPACE;
                }
            }
        }
    }

    public String boardPrint() {
        StringBuilder boardString = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                boardString.append(board[i][j]);
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
}
