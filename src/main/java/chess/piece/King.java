package chess.piece;

import chess.ChessBoard;
import chess.Color;
import chess.Movement;
import chess.Position;
import java.util.Set;

public class King extends Piece {

    private static final Set<Movement> MOVEMENTS = Set.of(
            Movement.UP, Movement.DOWN, Movement.LEFT, Movement.RIGHT
    );

    public King(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected boolean isMovable(ChessBoard chessBoard, Position to) {
        for (Movement movement : MOVEMENTS) {
            Position curr = position;
            if (!curr.canMove(movement)) {
                break;
            }
            curr = curr.move(movement);
            if (curr.equals(to)) {
                return true;
            }
        }
        return false;
    }
}
