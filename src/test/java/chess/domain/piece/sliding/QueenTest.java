package chess.domain.piece.sliding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import chess.domain.color.Color;
import chess.domain.piece.Position;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueenTest {

    @Test
    @DisplayName("오른쪽으로 이동시 중간 경로를 찾는다.")
    void findPathToRight() {
        Queen queen = new Queen(new Position(1, 1), Color.WHITE);
        Set<Position> pathTo = queen.findPathTo(new Position(4, 1));
        assertThat(pathTo)
                .containsExactlyInAnyOrder(new Position(2, 1), new Position(3, 1));
    }

    @Test
    @DisplayName("위쪽으로 이동시 중간 경로를 찾는다.")
    void findPathToUp() {
        Queen queen = new Queen(new Position(1, 1), Color.WHITE);
        Set<Position> pathTo = queen.findPathTo(new Position(1, 4));
        assertThat(pathTo)
                .containsExactlyInAnyOrder(new Position(1, 2), new Position(1, 3));
    }

    @Test
    @DisplayName("대각선으로 이동시 중간 경로를 찾는다.")
    void findPathToDiagonal() {
        Queen queen = new Queen(new Position(1, 1), Color.WHITE);
        Set<Position> pathTo = queen.findPathTo(new Position(4, 4));
        assertThat(pathTo)
                .containsExactlyInAnyOrder(new Position(2, 2), new Position(3, 3));
    }

    @Test
    @DisplayName("여덟 방향이 아닌 방향으로 이동시 예외가 발생한다.")
    void findPathToInvalidDestination() {
        Queen queen = new Queen(new Position(1, 1), Color.WHITE);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> queen.findPathTo(new Position(2, 4)))
                .withMessage("이동할 수 없습니다.");
    }

    @Test
    @DisplayName("Queen은 9점이다.")
    void score() {
        Queen queen = new Queen(new Position(1, 1), Color.WHITE);

        assertThat(queen.score()).isEqualTo(9);
    }
}
