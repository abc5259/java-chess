package controller.command;

import domain.game.ChessGame;
import domain.position.Position;
import java.util.List;
import java.util.regex.Pattern;
import service.ChessGameService;
import service.ServiceFactory;
import view.OutputView;

public class MoveCommand implements Command {
    private static final int SOURCE_INDEX = 0;
    private static final int TARGET_INDEX = 1;
    private static final int MOVE_ARGUMENTS_SIZE = 2;
    private static final String MOVE_COMMAND_REGEX_FORMAT = "^[a-h][1-8]";
    private static final Pattern MOVE_COMMAND_PATTERN = Pattern.compile(MOVE_COMMAND_REGEX_FORMAT);

    private final Position source;
    private final Position target;
    private final ChessGameService chessGameService = ServiceFactory.getInstance().getChessGameService();


    public MoveCommand(List<String> arguments) {
        validate(arguments);
        this.source = new Position(arguments.get(SOURCE_INDEX));
        this.target = new Position(arguments.get(TARGET_INDEX));
    }


    private void validate(List<String> arguments) {
        checkArgumentCount(arguments);
        checkArgumentPattern(arguments);
    }

    private void checkArgumentCount(List<String> arguments) {
        if (arguments.size() != MOVE_ARGUMENTS_SIZE) {
            throw new IllegalArgumentException("잘못된 move 명령어 입니다.");
        }
    }

    private void checkArgumentPattern(List<String> arguments) {
        if (isNotAllMatchToPattern(arguments)) {
            throw new IllegalArgumentException("source와 target을 다시 입력해주세요");
        }
    }


    private boolean isNotAllMatchToPattern(List<String> arguments) {
        return !arguments.stream()
                .allMatch(this::isValidPositionPattern);
    }

    private boolean isValidPositionPattern(final String input) {
        return MOVE_COMMAND_PATTERN.matcher(input).matches();
    }


    @Override
    public void execute(ChessGame chessGame, OutputView outputView) {
        chessGame.move(source, target);

        chessGameService.updateChessGame(chessGame);
        outputView.printChessBoard(chessGame.getChessBoard());

        if (chessGame.isEnd()) {
            outputView.printWinner(chessGame.getColor());
        }
    }
}
