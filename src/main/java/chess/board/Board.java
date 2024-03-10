package chess.board;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static chess.board.Rank.LENGTH;
import static utils.StringUtils.*;

public class Board {
    private static final String[] piecesOrder =
            {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};

    private final List<Rank> board;

    public Board() {
        board = new ArrayList<>();
    }

    public void initialize() {
        addBoardBlackPieces();
        addBoardBlankRank();
        addBoardWhitePieces();
    }

    private void addBoardBlackPieces() {
        Rank rank = new Rank();
        for (int i = 0; i < LENGTH; i++) {
            rank.add(Piece.createBlackPiece(piecesOrder[i]));
        }
        board.addFirst(rank);

        addBoardBlackPawns();
    }

    private void addBoardBlackPawns() {
        Rank rank = new Rank();
        for (int i = 0; i < LENGTH; i++) {
            rank.add(Piece.createBlackPiece("pawn"));
        }
        board.add(rank);
    }

    private void addBoardBlankRank() {
        for (int i = 2; i <= 5; i++) {
            board.add(new Rank());
        }
    }

    private void addBoardWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < LENGTH; i++) {
            rank.add(Piece.createWhitePiece("pawn"));
        }
        board.add(rank);
    }

    private void addBoardWhitePieces() {
        addBoardWhitePawns();

        Rank rank = new Rank();
        for (int i = 0; i < LENGTH; i++) {
            rank.add(Piece.createWhitePiece(piecesOrder[i]));
        }
        board.addLast(rank);
    }

    public void print() {
        System.out.println(showBoard());
    }

    public int pieceCount() {
        int sum = 0;
        for(Rank rank: board){
            if (!rank.isEmpty()) {
                sum += rank.size();
            }
        }
        return sum;
    }

    public String showBoard() {
        StringBuilder boardStatus = new StringBuilder();
        for (Rank rank : board) {
            boardStatus.append(appendNewLine(rank.getRankStatus()));
        }
        return boardStatus.toString();
    }

    public int countPiece(Piece piece) {
        int count = 0;
        for (Rank rank : board) {
            count += rank.countPiece(piece);
        }
        return count;
    }

    // 올바른 입력이 들어왔다고 가정 TODO: 입력 검증(at Input 클래스)
    public Piece findPiece(final String position) {
        int index0 = position.charAt(0) - 'a';
        int index1 = LENGTH - (position.charAt(1) - '1') - 1;

        return board.get(index1).findPiece(index0).orElse(null);
    }
}
