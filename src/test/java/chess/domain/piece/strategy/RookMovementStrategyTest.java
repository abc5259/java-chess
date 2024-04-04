package chess.domain.piece.strategy;

import chess.domain.piece.Piece;
import chess.domain.piece.PieceColor;
import chess.domain.piece.PieceType;
import chess.domain.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RookMovementStrategyTest {

    static Stream<Arguments> canRookMoveCrossArguments() {
        return Stream.of(
                Arguments.arguments(Position.D4, Position.D3),
                Arguments.arguments(Position.D4, Position.H4),
                Arguments.arguments(Position.D4, Position.D7),
                Arguments.arguments(Position.D4, Position.A4)
        );
    }

    static Stream<Arguments> cannotRookMoveDiagonalArguments() {
        return Stream.of(
                Arguments.arguments(Position.D4, Position.E5),
                Arguments.arguments(Position.D4, Position.C5),
                Arguments.arguments(Position.D4, Position.E3),
                Arguments.arguments(Position.D4, Position.C3)
        );
    }

    @DisplayName("룩은 상하좌우로 원하는 만큼 움직일 수 있다.")
    @ParameterizedTest
    @MethodSource("canRookMoveCrossArguments")
    void canRookMoveDirection(Position source, Position target) {
        // given
        Piece rook = new Piece(PieceType.ROOK, PieceColor.BLACK);

        // when
        boolean result = rook.isInMovableRange(source, target);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("룩은 대각선으로 움직일 수 없다.")
    @ParameterizedTest
    @MethodSource("cannotRookMoveDiagonalArguments")
    void cannotRookMoveDiagonal(Position source, Position target) {
        // given
        Piece rook = new Piece(PieceType.ROOK, PieceColor.BLACK);

        // when
        boolean result = rook.isInMovableRange(source, target);

        // then
        assertThat(result).isFalse();
    }
}
