package chess.domain.chessGame;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.board.ChessBoardService;
import chess.domain.board.MemoryBoardRepository;
import chess.domain.ChessGameService;
import chess.domain.Color;
import chess.domain.position.Column;
import chess.domain.Piece;
import chess.domain.PieceType;
import chess.domain.position.Position;
import chess.domain.position.Row;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhitePawnTest {
    /**
     * ........  8 (rank 8)
     * ........  7
     * ........  6
     * ........  5
     * ........  4
     * ..R.R...  3
     * ...p....  2
     * ........  1 (rank 1)
     *
     * abcdefgh
     */
    @Test
    @DisplayName("화이트 폰 시작 위치에서 양쪽 대각선에 상대 기물이 있고 앞 2칸은 비어있다.")
    void startPositionPawnWithOnlyAttackablePositions() {
        Position targetPosition = new Position(Row.RANK2, Column.D);
        Color currentTurn = Color.WHITE;
        ChessBoardService chessBoardService = new ChessBoardService(new MemoryBoardRepository(
                Map.of(
                        targetPosition, new Piece(PieceType.WHITE_PAWN, currentTurn),
                        new Position(Row.RANK3, Column.C), new Piece(PieceType.ROOK, currentTurn.opposite()),
                        new Position(Row.RANK3, Column.E), new Piece(PieceType.ROOK, currentTurn.opposite())
                )
        ));

        List<Position> result = chessBoardService.generateMovablePositions(targetPosition, currentTurn);

        assertThat(result).containsExactlyInAnyOrder(
                new Position(Row.RANK3, Column.C),
                new Position(Row.RANK3, Column.E),
                new Position(Row.RANK3, Column.D),
                new Position(Row.RANK4, Column.D)
        );
    }

    /**
     * ........  8 (rank 8)
     * ........  7
     * ........  6
     * ........  5
     * ........  4
     * ..p.....  3
     * ...p....  2
     * ........  1 (rank 1)
     *
     * abcdefgh
     */
    @Test
    @DisplayName("화이트 폰 시작 위치에서 앞으로만 이동할 수 있는 경우")
    void startPositionPawnWithFreePositions() {
        Position targetPosition = new Position(Row.RANK2, Column.D);
        Color currentTurn = Color.WHITE;
        ChessBoardService chessBoardService = new ChessBoardService(new MemoryBoardRepository(
                Map.of(
                        targetPosition, new Piece(PieceType.WHITE_PAWN, currentTurn),
                        new Position(Row.RANK3, Column.C), new Piece(PieceType.WHITE_PAWN, currentTurn)
                )
        ));

        List<Position> result = chessBoardService.generateMovablePositions(targetPosition, currentTurn);

        assertThat(result).containsExactlyInAnyOrder(
                new Position(Row.RANK3, Column.D),
                new Position(Row.RANK4, Column.D)
        );
    }

    /**
     * ........  8 (rank 8)
     * ........  7
     * ........  6
     * ........  5
     * ........  4
     * ..pP....  3
     * ...p....  2
     * ........  1 (rank 1)
     *
     * abcdefgh
     */
    @Test
    @DisplayName("화이트 폰 시작 위치에서 움직일 수 없는 경우")
    void startPositionPawnWithCantMovePositions() {
        Position targetPosition = new Position(Row.RANK2, Column.D);
        Color currentTurn = Color.WHITE;
        ChessBoardService chessBoardService = new ChessBoardService(new MemoryBoardRepository(
                Map.of(
                        targetPosition, new Piece(PieceType.WHITE_PAWN, currentTurn),
                        new Position(Row.RANK3, Column.C), new Piece(PieceType.WHITE_PAWN, currentTurn),
                        new Position(Row.RANK3, Column.D), new Piece(PieceType.BLACK_PAWN, currentTurn.opposite())
                )
        ));

        List<Position> result = chessBoardService.generateMovablePositions(targetPosition, currentTurn);

        assertThat(result).isEmpty();
    }
}
