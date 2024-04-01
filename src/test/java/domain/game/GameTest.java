package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.board.Board;
import domain.board.Position;
import domain.piece.Bishop;
import domain.piece.King;
import domain.piece.Knight;
import domain.piece.Pawn;
import domain.piece.Piece;
import domain.piece.Queen;
import domain.piece.Rook;
import domain.piece.info.Color;
import domain.piece.info.File;
import domain.piece.info.Rank;
import domain.piece.info.Type;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    private final Game game = new Game();
    private final Game kingDeadGame = new Game(new Board(generateDeadKingSquares()));

    @Test
    @DisplayName("Game은 생성될 때 Init 상태이다.")
    void gameInit() {
        assertThat(game.isInit()).isTrue();
    }

    @Test
    @DisplayName("체스 게임을 플레이하려면 시작 상태로 변경되어야 한다.")
    void startBeforeMove() {
        Position source = new Position(File.B, Rank.TWO);
        Position target = new Position(File.B, Rank.FOUR);

        assertThatThrownBy(() -> game.moveByPosition(source, target))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("게임 플레이 중이 아닙니다.");
    }

    @Test
    @DisplayName("게임은 현재 시작 상태인지 확인할 수 있다.")
    void isStarted() {
        assertAll(
                () -> assertThat(game.isStarted()).isFalse(),
                () -> {
                    game.start();
                    assertThat(game.isStarted()).isTrue();
                },
                () -> {
                    game.end();
                    assertThat(game.isStarted()).isFalse();
                }
        );
    }

    @Test
    @DisplayName("시작 상태가 되면 종료 상태가 될 때까지 다시 시작할 수 없다.")
    void cannotReStartBeforeEnd() {
        game.start();

        assertThatThrownBy(game::start)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("게임이 이미 시작되어 있습니다.");
    }

    @Test
    @DisplayName("시작 상태에선 기물을 이동할 수 있다.")
    void canMovePiecesInStart() {
        game.start();

        Position source = new Position(File.B, Rank.TWO);
        Position target = new Position(File.B, Rank.FOUR);

        assertThatCode(() -> game.moveByPosition(source, target))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시작 상태에서 종료 상태가 되면 기물을 이동할 수 없다.")
    void cannotMovePiecesInEnd() {
        game.start();
        game.end();

        Position source = new Position(File.B, Rank.TWO);
        Position target = new Position(File.B, Rank.FOUR);

        assertThatThrownBy(() -> game.moveByPosition(source, target))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("게임 플레이 중이 아닙니다.");
    }

    @Test
    @DisplayName("Init 상태에서 바로 종료할 수 있다.")
    void endInInit() {
        game.end();

        assertThat(game.isEnded()).isTrue();
    }

    @Test
    @DisplayName("게임은 현재 상태가 종료가 아닌지 확인할 수 있다.")
    void isNotEnded() {
        assertAll(
                () -> assertThat(game.isNotEnded()).isTrue(),
                () -> {
                    game.start();
                    assertThat(game.isNotEnded()).isTrue();
                },
                () -> {
                    game.end();
                    assertThat(game.isNotEnded()).isFalse();
                }
        );
    }

    @Test
    @DisplayName("게임은 종료 상태에서 다시 시작 상태로 변경될 수 있다.")
    void restartAfterEnd() {
        game.end();

        assertThatCode(game::start)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("게임은 종료 상태에서 다시 종료할 수 없다.")
    void cannotEndAfterEnd() {
        game.end();

        assertThatThrownBy(game::end)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("게임이 이미 종료되어 있습니다.");
    }

    @Test
    @DisplayName("게임은 종료되었는지 확인할 수 있다.")
    void isEnded() {
        assertAll(
                () -> assertThat(game.isEnded()).isFalse(),
                () -> {
                    game.start();
                    assertThat(game.isEnded()).isFalse();
                },
                () -> {
                    game.end();
                    assertThat(game.isEnded()).isTrue();
                }
        );
    }

    @Test
    @DisplayName("게임은 King이 죽으면 종료 상태가 된다.")
    void checkKingIsDead() {
        kingDeadGame.start();
        kingDeadGame.moveByPosition(new Position(File.F, Rank.FOUR), new Position(File.E, Rank.SIX));

        assertThat(kingDeadGame.isEnded()).isTrue();
    }

    @Test
    @DisplayName("게임은 보드를 반환할 수 있다.")
    void getBoard() {
        assertThat(game.board()).isNotNull();
    }

    private Map<Position, Piece> generateDeadKingSquares() {
        return new HashMap<>(Map.ofEntries(
                Map.entry(new Position(File.C, Rank.EIGHT), new Rook(Color.BLACK, Type.ROOK)),
                Map.entry(new Position(File.A, Rank.SEVEN), new Pawn(Color.BLACK, Type.PAWN)),
                Map.entry(new Position(File.C, Rank.SEVEN), new Pawn(Color.BLACK, Type.PAWN)),
                Map.entry(new Position(File.D, Rank.SEVEN), new Bishop(Color.BLACK, Type.BISHOP)),
                Map.entry(new Position(File.B, Rank.SIX), new Pawn(Color.BLACK, Type.PAWN)),
                Map.entry(new Position(File.E, Rank.SIX), new Queen(Color.BLACK, Type.QUEEN)),
                Map.entry(new Position(File.F, Rank.FOUR), new Knight(Color.WHITE, Type.KNIGHT)),
                Map.entry(new Position(File.G, Rank.FOUR), new Queen(Color.WHITE, Type.QUEEN)),
                Map.entry(new Position(File.F, Rank.THREE), new Pawn(Color.WHITE, Type.PAWN)),
                Map.entry(new Position(File.H, Rank.THREE), new Pawn(Color.WHITE, Type.PAWN)),
                Map.entry(new Position(File.F, Rank.TWO), new Pawn(Color.WHITE, Type.PAWN)),
                Map.entry(new Position(File.G, Rank.TWO), new Pawn(Color.WHITE, Type.PAWN)),
                Map.entry(new Position(File.E, Rank.ONE), new Rook(Color.WHITE, Type.ROOK)),
                Map.entry(new Position(File.H, Rank.ONE), new King(Color.WHITE, Type.KING))
        ));
    }
}
