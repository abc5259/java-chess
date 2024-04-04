package chess.domain.board;

import chess.domain.piece.Piece;
import chess.domain.piece.PieceColor;
import chess.domain.piece.PieceType;
import chess.domain.position.Position;
import chess.dto.BoardStatusDto;
import chess.dto.PieceInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ChessBoardTest {

    @DisplayName("보드 정보를 통해 체스보드를 생성한다")
    @Test
    void createChessBoard() {
        assertThatCode(() -> new ChessBoard(ChessBoardGenerator.getInstance()))
                .doesNotThrowAnyException();
    }

    @DisplayName("체스 보드는 기물을 움직일 수 있다.")
    @Test
    void movePawnB2ToB3() {
        // given
        ChessBoard chessBoard = new ChessBoard(ChessBoardGenerator.getInstance());

        // when
        chessBoard.move(
                Position.B2,
                Position.B3
        );

        // then
        BoardStatusDto boardStatusDto = chessBoard.state();
        List<PieceInfoDto> pieceInfoDtos = boardStatusDto.pieceInfoDtos();

        assertAll(
                () -> assertThat(pieceInfoDtos.contains(new PieceInfoDto(1, 2, PieceType.PAWN, PieceColor.WHITE))).isTrue(),
                () -> assertThat(pieceInfoDtos.contains(new PieceInfoDto(1, 1, PieceType.PAWN, PieceColor.WHITE))).isFalse()
        );
    }

    @DisplayName("Source와 Target이 같으면 이동할 수 없다.")
    @Test
    void isSamePosition() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.PAWN, PieceColor.WHITE));

        generatorStub.setBoard(board);
        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatThrownBy(() -> chessBoard.move(
                Position.B2,
                Position.B2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 이동 위치가 올바르지 않습니다.");
    }

    @DisplayName("Source와 Target이 같은 색이면 이동할 수 없다.")
    @Test
    void isTargetSameColor() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.PAWN, PieceColor.WHITE));
        board.put(Position.B3, new Piece(PieceType.PAWN, PieceColor.WHITE));

        generatorStub.setBoard(board);
        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatThrownBy(() -> chessBoard.move(
                Position.B2,
                Position.B3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동할 수 없는 target입니다.");
    }

    @DisplayName("Source에 기물이 존재하지 않으면 이동할 수 없다.")
    @Test
    void notExistSource() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        generatorStub.setBoard(board);
        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatThrownBy(() -> chessBoard.move(
                Position.B3,
                Position.B2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 이동 위치가 올바르지 않습니다.");
    }

    @DisplayName("기물이 이동할 수 없는 방식으로 움직이면 예외를 발생한다.")
    @Test
    void validatePieceMovement() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.PAWN, PieceColor.WHITE));

        generatorStub.setBoard(board);
        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatThrownBy(() -> chessBoard.move(
                Position.B2,
                Position.B7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("기물이 이동할 수 없는 방식입니다.");
    }

    @DisplayName("나이트를 제외한 나머지 기물은 Source와 Target 사이에 다른 기물이 존재하면 예외를 발생한다.")
    @Test
    void validateBetweenSourceAndTarget() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.ROOK, PieceColor.WHITE));
        board.put(Position.B3, new Piece(PieceType.PAWN, PieceColor.WHITE));
        generatorStub.setBoard(board);

        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatThrownBy(() -> chessBoard.move(
                Position.B2,
                Position.B7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동하고자 하는 경로 사이에 기물이 존재합니다.");
    }

    @DisplayName("나이트는 Source와 Target 사이에 다른 기물이 존재해도 이동할 수 있다.")
    @Test
    void canKnightMove() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.KNIGHT, PieceColor.WHITE));
        board.put(Position.B3, new Piece(PieceType.PAWN, PieceColor.WHITE));
        generatorStub.setBoard(board);

        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatCode(() -> chessBoard.move(
                Position.B2,
                Position.C4)).doesNotThrowAnyException();
    }

    @DisplayName("폰은 타겟에 상대 기물이 있으면 대각선으로 이동할 수 있다.")
    @Test
    void canPawnMoveDiagonal() {
        // given
        PieceInfoDto expected = PieceInfoDto.of(Position.C3, new Piece(PieceType.PAWN, PieceColor.WHITE));

        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.PAWN, PieceColor.WHITE));
        board.put(Position.C3, new Piece(PieceType.KING, PieceColor.BLACK));
        generatorStub.setBoard(board);

        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when
        chessBoard.move(
                Position.B2,
                Position.C3);
        List<PieceInfoDto> pieceInfoDtos = chessBoard.state().pieceInfoDtos();

        // then
        assertThat(pieceInfoDtos).contains(expected);
    }

    @DisplayName("폰은 타겟에 상대 기물이 없으면 대각선으로 이동할 수 없다.")
    @Test
    void cannotPawnMoveDiagonalIfNoPiece() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.PAWN, PieceColor.WHITE));
        generatorStub.setBoard(board);

        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatThrownBy(() -> chessBoard.move(
                Position.B2,
                Position.C3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("폰은 상대 기물이 존재할 때만 대각선 이동이 가능합니다.");
    }

    @DisplayName("폰은 앞으로는 공격할 수 없다..")
    @Test
    void cannotPawnAttackVertical() {
        // given
        BoardGeneratorStub generatorStub = new BoardGeneratorStub();
        HashMap<Position, Piece> board = new HashMap<>();
        board.put(Position.B2, new Piece(PieceType.PAWN, PieceColor.WHITE));
        board.put(Position.B3, new Piece(PieceType.PAWN, PieceColor.BLACK));
        generatorStub.setBoard(board);

        ChessBoard chessBoard = new ChessBoard(generatorStub);

        // when & then
        assertThatThrownBy(() -> chessBoard.move(
                Position.B2,
                Position.B3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("폰은 대각선으로만 공격할 수 있습니다.");
    }
}
