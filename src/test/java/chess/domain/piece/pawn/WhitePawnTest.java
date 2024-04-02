package chess.domain.piece.pawn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import chess.domain.color.Color;
import chess.domain.piece.PieceType;
import chess.domain.piece.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhitePawnTest {

    @Test
    @DisplayName("왼쪽 위, 오른쪽 위 방향의 공격 음직임인지 확인한다")
    void checkIsCaptureMove() {
        WhitePawn whitePawn = new WhitePawn(new Position(2, 2));
        assertAll(
                () -> assertThat(whitePawn.isCaptureMove(new Position(1, 3))).isTrue(),
                () -> assertThat(whitePawn.isCaptureMove(new Position(2, 3))).isFalse(),
                () -> assertThat(whitePawn.isCaptureMove(new Position(3, 3))).isTrue()
        );
    }

    @Test
    @DisplayName("왼쪽, 오른쪽으로는 이동할 수 없다.")
    void findPathToByInvalidDestinationLeftRight() {
        WhitePawn whitePawn = new WhitePawn(new Position(2, 2));

        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> whitePawn.findPathTo(new Position(1, 2)))
                        .withMessage("이동할 수 없습니다."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> whitePawn.findPathTo(new Position(3, 2)))
                        .withMessage("이동할 수 없습니다.")
        );
    }

    @Test
    @DisplayName("(2, 2)일 때 (2, 4)으로는 이동할 수 없다.")
    void findPathToByInvalidDestinationUpUp() {
        WhitePawn whitePawn = new WhitePawn(new Position(2, 2));
        Position destination = new Position(2, 4);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> whitePawn.findPathTo(destination))
                .withMessage("이동할 수 없습니다.");
    }

    @Test
    @DisplayName("(2, 2)일 때 (2, 1)으로는 이동할 수 없다.")
    void findPathToByInvalidDestinationDown() {
        WhitePawn whitePawn = new WhitePawn(new Position(2, 2));
        Position destination = new Position(2, 1);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> whitePawn.findPathTo(destination))
                .withMessage("이동할 수 없습니다.");
    }

    @Test
    @DisplayName("(2, 2)일 때 (2, 5)로는 이동할 수 없다.")
    void findPathToByInvalidFarDestination() {
        WhitePawn whitePawn = new WhitePawn(new Position(2, 2));
        Position destination = new Position(2, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> whitePawn.findPathTo(destination))
                .withMessage("이동할 수 없습니다.");
    }

    @Test
    @DisplayName("현재 말의 색상과 동일한 색을 가졌는지 확인한다.")
    void isSameColor() {
        WhitePawn whitePawn = new WhitePawn(new Position(2, 2));

        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(whitePawn.isSameColor(Color.WHITE)).isTrue(),
                () -> assertThat(whitePawn.isSameColor(Color.BLACK)).isFalse()
        );
    }

    @Test
    @DisplayName("말의 색상과 모양에 맞는 PieceType을 반환한다.")
    void getPieceType() {
        WhitePawn whitePawn = new WhitePawn(new Position(2, 2));

        assertThat(whitePawn.pieceType()).isEqualTo(PieceType.WHITE_PAWN);
    }

    @Test
    @DisplayName("WhitePawn은 1점이다.")
    void score() {
        WhitePawn whitePawn = new WhitePawn(new Position(1, 1));

        assertThat(whitePawn.score()).isEqualTo(1);
    }
}
