package chess.domain;

import chess.domain.piece.abstractPiece.Piece;
import chess.domain.piece.character.Team;
import chess.exception.ImpossibleMoveException;

public class Game {
    private final Board board;
    private final String roomName;
    private Team currentTeam;

    public Game(Board board, String roomName) {
        this(board, roomName, Team.WHITE);
    }

    public Game(Board board, Team team) {
        this(board, "new game", team);
    }

    public Game(Board board, String roomName, Team team) {
        this.board = board;
        this.roomName = roomName;
        this.currentTeam = team;
    }

    public Piece movePiece(Movement movement) {
        board.validateSameTeamByPosition(movement.source(), currentTeam);
        Piece movedPiece = board.move(movement);
        validateCheck();
        currentTeam = currentTeam.opponent();
        return movedPiece;
    }

    private void validateCheck() {
        if (board.checkState(currentTeam) == State.CHECKED) {
            throw new ImpossibleMoveException("체크 상태를 벗어나지 않았습니다.");
        }
    }

    public boolean isMated() {
        State state = board.checkState(currentTeam);
        return state == State.CHECKMATE || state == State.STALEMATE;
    }

    public State checkState() {
        return board.checkState(currentTeam);
    }

    public Board getBoard() {
        return board;
    }

    public String getRoomName() {
        return roomName;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }
}
