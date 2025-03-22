package chess.piece;

import chess.ChessBoard;
import chess.Color;
import chess.Position;

public class Bishop extends Piece {

    public Bishop(Color color, Position position) {
        super(color, position);
    }

    @Override
    boolean isMovable(ChessBoard chessBoard, Position to) {
        return false;
    }
}
