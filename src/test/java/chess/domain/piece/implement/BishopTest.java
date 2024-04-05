package chess.domain.piece.implement;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.board.Direction;
import chess.domain.board.LocationState;
import chess.domain.board.Path;
import chess.domain.board.Step;
import chess.domain.piece.Color;
import chess.domain.piece.Score;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BishopTest {
    private static final Bishop BISHOP = new Bishop(Color.BLACK);

    @DisplayName("한 방향으로 이루어지지 않은 경로로 움직일 수 없다.")
    @Test
    void tooManyDirectionTest() {
        Path manyDirectionPath = new Path(List.of(
                new Step(Direction.DOWN_LEFT, LocationState.EMPTY),
                new Step(Direction.DOWN_RIGHT, LocationState.EMPTY)
        ));

        assertThat(BISHOP.canMove(manyDirectionPath))
                .isFalse();
    }

    @DisplayName("경로 중간에 기물이 위치한다면 움직일 수 없다.")
    @Test
    void pathHasPieceTest() {
        Path notEmptyPath = new Path(List.of(
                new Step(Direction.DOWN_LEFT, LocationState.EMPTY),
                new Step(Direction.DOWN_LEFT, LocationState.ALLY),
                new Step(Direction.DOWN_LEFT, LocationState.EMPTY)
        ));

        assertThat(BISHOP.canMove(notEmptyPath))
                .isFalse();
    }

    @DisplayName("목적지에 아군이 존재한다면 움직일 수 없다.")
    @Test
    void allyLocatedAtTargetTest() {
        Path manyDirectionPath = new Path(List.of(
                new Step(Direction.DOWN_LEFT, LocationState.EMPTY),
                new Step(Direction.DOWN_LEFT, LocationState.EMPTY),
                new Step(Direction.DOWN_LEFT, LocationState.ALLY)
        ));

        assertThat(BISHOP.canMove(manyDirectionPath))
                .isFalse();
    }

    @DisplayName("수직 방향으로 움직일 수 없다.")
    @Test
    void canNotMoveDiagonalTest() {
        Path diagonalDirectionPath = new Path(List.of(
                new Step(Direction.UP, LocationState.EMPTY),
                new Step(Direction.UP, LocationState.EMPTY),
                new Step(Direction.UP, LocationState.EMPTY)
        ));

        assertThat(BISHOP.canMove(diagonalDirectionPath))
                .isFalse();
    }

    @DisplayName("최대 7칸까지 움직일 수 있다.")
    @Test
    void maxDistanceMoveTest() {
        Path manyDirectionPath = new Path(List.of(
                new Step(Direction.DOWN_RIGHT, LocationState.EMPTY),
                new Step(Direction.DOWN_RIGHT, LocationState.EMPTY),
                new Step(Direction.DOWN_RIGHT, LocationState.EMPTY),
                new Step(Direction.DOWN_RIGHT, LocationState.EMPTY),
                new Step(Direction.DOWN_RIGHT, LocationState.EMPTY),
                new Step(Direction.DOWN_RIGHT, LocationState.EMPTY),
                new Step(Direction.DOWN_RIGHT, LocationState.ENEMY)
        ));

        assertThat(BISHOP.canMove(manyDirectionPath))
                .isTrue();
    }

    @DisplayName("비숍은 3점으로 계산된다.")
    @Test
    void scoreTest() {
        assertThat(BISHOP.getPieceScore()).isEqualTo(new Score(3));
    }
}
