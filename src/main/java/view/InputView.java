package view;

import controller.game.command.GameCommand;
import controller.room.command.RoomCommand;
import controller.user.command.UserCommand;
import dto.RoomDto;
import view.command.CommandInput;
import view.command.GameCommandType;
import view.command.RoomCommandType;
import view.command.UserCommandType;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WRONG_COMMAND_ERROR_MESSAGE = "잘못된 명령어입니다.";

    public static GameCommand readGameCommand() {
        try {
            CommandInput input = readCommandInput();
            return GameCommandType.getCommand(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(WRONG_COMMAND_ERROR_MESSAGE);
        }
    }

    public static RoomCommand readRoomCommand(List<RoomDto> rooms) {
        try {
            CommandInput input = readCommandInput();
            return RoomCommandType.getCommand(input, rooms);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            throw new IllegalArgumentException(WRONG_COMMAND_ERROR_MESSAGE);
        }
    }

    public static UserCommand readUserCommand() {
        try {
            CommandInput input = readCommandInput();
            return UserCommandType.getCommand(input);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            throw new IllegalArgumentException(WRONG_COMMAND_ERROR_MESSAGE);
        }
    }

    private static CommandInput readCommandInput() {
        return new CommandInput(SCANNER.nextLine().strip());
    }
}
