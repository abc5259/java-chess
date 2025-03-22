package chess.piece;

import chess.ChessBoard;
import chess.Color;
import chess.Position;

public class Queen extends Piece {

    public Queen(Color color, Position position) {
        super(color, position);
    }

    @Override
    boolean isMovable(ChessBoard chessBoard, Position to) {
        return false;
    }
}
