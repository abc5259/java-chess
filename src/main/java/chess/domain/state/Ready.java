package chess.domain.state;

import static chess.utils.Constant.START_COMMAND;

import chess.domain.board.ChessBoard;
import java.util.List;

public class Ready implements GameState {
    private final ChessBoard chessBoard;

    public Ready(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    @Override
    public GameState play(List<String> inputCommand) {
        String command = inputCommand.get(0);
        if (START_COMMAND.equals(command)) {
            return new Progress(chessBoard);
        }
        throw new UnsupportedOperationException("게임이 시작되지 않았습니다.");
    }

    @Override
    public boolean isEnd() {
        return false;
    }
}
