package chess.domain.piece;

import chess.domain.pieceinfo.PieceInfo;
import chess.domain.pieceinfo.Position;
import chess.domain.pieceinfo.Team;
import chess.domain.strategy.RookMoveStrategy;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RookTest {

    private static Stream<Arguments> rookMoveTestParameters() {
        return Stream.of(
                Arguments.of(Position.of("d4"), Position.of("d1"), Position.of("d1")),
                Arguments.of(Position.of("d4"), Position.of("a4"), Position.of("a4")),
                Arguments.of(Position.of("d4"), Position.of("d8"), Position.of("d8")),
                Arguments.of(Position.of("d4"), Position.of("h4"), Position.of("h4")),
                Arguments.of(Position.of("d4"), Position.of("b3"), Position.of("d4"))
        );
    }

    @DisplayName("룩은 한 번에 수직 혹은 수평으로 여러 칸 이동 가능하다.")
    @ParameterizedTest
    @MethodSource("rookMoveTestParameters")
    void rookMoveTest(Position currentPosition, Position newPosition, Position expectedMovedPosition) {
        PieceInfo pieceInfo = new PieceInfo(currentPosition, Team.WHITE);
        Piece rook = new Rook(pieceInfo, new RookMoveStrategy());
        Piece movedRook = rook.move(newPosition, false, false, false);

        Position actualMovedPosition = movedRook.getPosition();

        Assertions.assertThat(actualMovedPosition).isEqualTo(expectedMovedPosition);
    }
}
