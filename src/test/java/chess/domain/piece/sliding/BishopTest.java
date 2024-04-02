package chess.domain.piece.sliding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import chess.domain.color.Color;
import chess.domain.piece.Position;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BishopTest {

    @Test
    @DisplayName("대각선 이동시 중간경로를 찾는다.")
    void findPathToDiagonal() {
        Bishop bishop = new Bishop(new Position(1, 1), Color.WHITE);
        Set<Position> pathTo = bishop.findPathTo(new Position(4, 4));
        assertThat(pathTo)
                .containsExactlyInAnyOrder(new Position(2, 2), new Position(3, 3));
    }

    @Test
    @DisplayName("대각선이 아닌 방향으로 이동하려하면 예외가 발생한다.")
    void findPathToInvalidDestination() {
        Bishop bishop = new Bishop(new Position(1, 1), Color.WHITE);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bishop.findPathTo(new Position(2, 1)))
                .withMessage("이동할 수 없습니다.");
    }

    @Test
    @DisplayName("Bishop은 3점이다.")
    void score() {
        Bishop bishop = new Bishop(new Position(1, 1), Color.WHITE);

        assertThat(bishop.score()).isEqualTo(3);
    }
}
