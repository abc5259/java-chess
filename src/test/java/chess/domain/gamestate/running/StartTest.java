package chess.domain.gamestate.running;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import chess.domain.board.Board;
import chess.domain.gamestate.CommandType;
import chess.domain.gamestate.State;
import chess.domain.gamestate.finished.End;
import chess.utils.BoardUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StartTest {

    private Board board;
    private State state;

    @BeforeEach
    void setUp() {
        board = BoardUtil.generateInitialBoard();
        state = new Start(board);
    }

    @DisplayName("상태 변경 - start 상태에서 move로 변경가능하다.")
    @Test
    void changeState_1() {
        // given
        CommandType move = CommandType.MOVE;

        // when
        state = state.processCommand(move);

        // then
        assertThat(state).isInstanceOf(Move.class);
    }

    @DisplayName("상태 변경 - start 상태에서 end로 변경가능하다.")
    @Test
    void changeState_2() {
        // given
        CommandType end = CommandType.END;

        // when
        state = state.processCommand(end);

        // then
        assertThat(state).isInstanceOf(End.class);
    }

    @DisplayName("상태 변경 - ready 상태에서 start 상태로 변경 불가능하다.")
    @Test
    void changeState_3() {
        // given
        CommandType start = CommandType.START;

        // then
        assertThatThrownBy(() -> state.processCommand(start))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상태 변경 - ready 상태에서 status 상태로 변경 불가능하다.")
    @Test
    void changeState_4() {
        // given
        CommandType status = CommandType.STATUS;

        // then
        assertThatThrownBy(() -> state.processCommand(status))
            .isInstanceOf(IllegalArgumentException.class);
    }
}