package chess.piece;

import chess.ChessBoard;
import chess.Color;
import chess.Position;

public class Pawn extends Piece {


    public Pawn(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected boolean isMovable(ChessBoard chessBoard, Position to) {
        return false;
    }
}
