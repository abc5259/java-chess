package controller.command;

import domain.game.ChessGame;
import java.util.List;
import view.OutputView;

public class EndCommand implements Command {
    public EndCommand(List<String> arguments) {
        validate(arguments);
    }

    private void validate(List<String> arguments) {
        if (!arguments.isEmpty()) {
            throw new IllegalArgumentException("잘못된 end 명령어 입니다.");
        }
    }

    @Override
    public void execute(ChessGame chessGame, OutputView outputView) {
        chessGame.end();
        outputView.printEndGame();
    }
}
