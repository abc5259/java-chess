package chess.domain.piece;

import java.util.Arrays;

public enum Column {
    A("a", 1),
    B("b", 2),
    C("c", 3),
    D("d", 4),
    E("e", 5),
    F("f", 6),
    G("g", 7),
    H("h", 8);

    private final String columnInput;
    private final int value;

    Column(final String columnInput, final int value) {
        this.columnInput = columnInput;
        this.value = value;
    }

    public static int findColumn(final String input) {
        return Arrays.stream(Column.values())
                .filter(column -> column.columnInput.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 열입니다."))
                .value;
    }

    public static Column findColumn(final int columnValue) {
        return Arrays.stream(Column.values())
                .filter(column -> column.value == columnValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 위치입니다."));
    }
}
