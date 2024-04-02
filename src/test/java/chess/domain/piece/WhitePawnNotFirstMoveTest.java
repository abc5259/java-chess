package chess.domain.piece;

import chess.domain.pieceinfo.PieceInfo;
import chess.domain.pieceinfo.Position;
import chess.domain.pieceinfo.Team;
import chess.domain.strategy.WhitePawnNotFirstMoveStrategy;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WhitePawnNotFirstMoveTest {

    private static Stream<Arguments> whitePawnMoveTestParameters() {
        return Stream.of(
                Arguments.of(Position.of("d4"), Position.of("d5"), Position.of("d5")),
                Arguments.of(Position.of("d4"), Position.of("d6"), Position.of("d4")),
                Arguments.of(Position.of("d4"), Position.of("d3"), Position.of("d4"))
        );
    }

    @DisplayName("처음 움직이는 것이 아닌 흰색 폰은 한 번에 한 칸 아래로 이동 가능하다.")
    @ParameterizedTest
    @MethodSource("whitePawnMoveTestParameters")
    void pawnMoveTest(Position currentPosition, Position newPosition, Position expectedMovedPosition) {
        PieceInfo pieceInfo = new PieceInfo(currentPosition, Team.WHITE);
        Piece whitePawnNotFirstMove = new WhitePawnNotFirstMove(pieceInfo, new WhitePawnNotFirstMoveStrategy());
        Piece movedPawn = whitePawnNotFirstMove.move(newPosition, false, false, false);

        Position actualMovedPosition = movedPawn.getPosition();

        Assertions.assertThat(actualMovedPosition).isEqualTo(expectedMovedPosition);
    }
}
