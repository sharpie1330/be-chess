package chess.board;

import chess.pieces.Piece;
import chess.pieces.PieceType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static chess.board.Rank.LENGTH;
import static chess.pieces.PieceType.*;
import static utils.StringUtils.*;

public class Board {
    private static final PieceType[] piecesOrder =
            {rook, knight, bishop, queen, king, bishop, knight, rook};

    private final List<Rank> board;

    public Board() {
        board = new ArrayList<>();
    }

    public void initialize() {
        addBoardBlackPieces();
        addBoardBlankRank(2, 6);
        addBoardWhitePieces();
    }

    public void initializeEmpty() {
        addBoardBlankRank(0, LENGTH);
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
            rank.add(Piece.createBlackPiece(PieceType.pawn));
        }
        board.add(rank);
    }

    private void addBoardBlankRank(int start, int end) {
        for (int i = start; i < end; i++) {
            Rank rank = new Rank();
            rank.initAsBlankRank();
            board.add(rank);
        }
    }

    private void addBoardWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < LENGTH; i++) {
            rank.add(Piece.createWhitePiece(PieceType.pawn));
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
        int[] index = verifyPosition(position);
        return board.get(index[1]).findPiece(index[0]).orElse(null);
    }

    public void move(String position, Piece piece) {
        int[] index = verifyPosition(position);

        Rank rank = board.get(index[1]);
        rank.set(index[0], piece);

        board.set(index[1], rank);
    }

    private int[] verifyPosition(String position) {
        return new int[]{position.charAt(0) - 'a', LENGTH - (position.charAt(1) - '1') - 1};
    }

    public double calculatePoint(String color) {
        double score = 0.0;
        for (Piece piece : findPiecesByColor(color)) {
            score += piece.getPieceType().getDefaultPoint();
        }
        return score;
    }

    public List<Piece> findPiecesByColor(String color) {
        List<Piece> pieces = new ArrayList<>();
        for (Rank rank : board) {
            pieces.addAll(rank.findPiecesByColor(color));
        }
        return pieces;
    }

    public List<Piece> sortPiecesByScoreAndColor(String color, boolean ascending) {
        Comparator<Piece> comparator = Comparator.comparing(
                p -> p.getPieceType().getDefaultPoint()
        );

        if (!ascending) {
            comparator = comparator.reversed();
        }

        return findPiecesByColor(color).stream()
                .sorted(comparator)
                .toList();
    }
}
