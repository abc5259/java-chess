package domain.score;

import domain.piece.Color;
import domain.piece.Piece;
import domain.position.File;
import domain.position.Position;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ScoreBoard {
    private static final double SAME_FILE_PAWN_SCORE = 0.5;
    private static final int UNIUQUE_WINNER_NUMBER = 1;

    private final Map<Color, Score> board;

    private ScoreBoard(Map<Color, Score> board) {
        this.board = board;
    }

    public static ScoreBoard of(Map<Position, Piece> piecesPosition) {
        Map<Color, Score> board = new EnumMap<>(Color.class);

        Arrays.stream(Color.values())
                .forEach(color -> board.put(color, calculateScore(piecesPosition, color)));

        return new ScoreBoard(board);
    }

    private static Score calculateScore(Map<Position, Piece> piecesPosition, Color color) {
        Score totalScore = calculateTotalScore(piecesPosition, color);
        Score pawnScore = calculateSameFilePawnScore(piecesPosition, color);
        return totalScore.subtract(pawnScore);
    }

    private static Score calculateTotalScore(Map<Position, Piece> piecesPosition, Color color) {
        return piecesPosition.values()
                .stream()
                .filter(piece -> piece.isSameColor(color))
                .map(Piece::getScore)
                .reduce(Score::plus)
                .orElseThrow(() -> new IllegalArgumentException("점수를 계산할 수 없습니다."));
    }

    private static Score calculateSameFilePawnScore(Map<Position, Piece> piecesPosition, Color color) {
        Score score = new Score(countPawnOnSameFile(piecesPosition, color));
        return score.multiply(SAME_FILE_PAWN_SCORE);
    }

    private static int countPawnOnSameFile(Map<Position, Piece> piecesPosition, Color color) {
        return countPawnByFile(piecesPosition, color)
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .filter(count -> count > 1)
                .sum();
    }

    private static Map<File, Long> countPawnByFile(Map<Position, Piece> piecesPosition, Color color) {
        return piecesPosition.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isSameColor(color))
                .filter(entry -> entry.getValue().isPawn())
                .collect(Collectors.groupingBy(
                        entry -> entry.getKey().getFile(),
                        Collectors.counting())
                );
    }

    public boolean isEqualScores() {
        return winnerColor().size() != UNIUQUE_WINNER_NUMBER;
    }

    public List<Color> winnerColor() {
        Score maxScore = Collections.max(board.values());

        return board.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxScore))
                .map(Entry::getKey)
                .toList();
    }

    public Map<Color, Score> getBoard() {
        return Collections.unmodifiableMap(board);
    }
}
