package controller.command;

import domain.game.ChessGame;
import java.util.List;
import service.ChessGameService;
import service.ServiceFactory;
import view.OutputView;

public class StartCommand implements Command {
    private final ChessGameService chessGameService = ServiceFactory.getInstance().getChessGameService();

    public StartCommand(List<String> arguments) {
        validate(arguments);
    }

    private void validate(List<String> arguments) {
        if (!arguments.isEmpty()) {
            throw new IllegalArgumentException("잘못된 start 명령어 입니다.");
        }
    }

    @Override
    public void execute(ChessGame chessGame, OutputView outputView) {
        chessGame.initialize();
        chessGame.start();

        chessGameService.updateChessGame(chessGame);

        outputView.printStartGame();
        outputView.printChessBoard(chessGame.getChessBoard());
    }
}
