package chess.domain.state;

import chess.domain.piece.Piece;
import chess.domain.position.Square;

import java.util.Map;

public interface Turn {
    TurnState turnState();
    Turn checkMovable(Map<Square, Piece> board, Square source, Square destination);
}
