package chess.domain.chessgame;

import chess.domain.board.Board;
import chess.domain.piece.*;
import chess.domain.pieceInfo.PieceInfo;
import chess.domain.pieceInfo.Position;
import chess.domain.pieceInfo.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ScoreBoardTest {

    @DisplayName("현재 살아있는 말에 따라 진영에 맞는 점수를 계산한다.")
    @Test
    void calculateScoreTest() {
        List<Piece> pieces = List.of(
                new Queen(new PieceInfo(Position.of("a3"), Team.WHITE)),
                new Rook(new PieceInfo(Position.of("a4"), Team.WHITE)),
                new Pawn(new PieceInfo(Position.of("a5"), Team.WHITE)),
                new Pawn(new PieceInfo(Position.of("a6"), Team.WHITE)),
                new Bishop(new PieceInfo(Position.of("b6"), Team.BLACK)),
                new Knight(new PieceInfo(Position.of("b5"), Team.BLACK)),
                new Pawn(new PieceInfo(Position.of("b4"), Team.BLACK))
        );

        Board board = new Board();
        pieces.forEach(piece -> board.placePiece(piece.getPosition(), piece));
        ScoreBoard scoreBoard = ScoreBoard.of(board);

        double expectedWhiteScore = 52.5;
        double expectedBlackScore = 43.5;

        double actualWhiteScore = scoreBoard.getWhiteScore();
        double actualBlackScore = scoreBoard.getBlackScore();

        Assertions.assertThat(actualWhiteScore).isEqualTo(expectedWhiteScore);
        Assertions.assertThat(actualBlackScore).isEqualTo(expectedBlackScore);
    }
}
