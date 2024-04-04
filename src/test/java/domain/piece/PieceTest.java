package domain.piece;

import static domain.piece.Color.BLACK;
import static domain.piece.Color.WHITE;
import static org.assertj.core.api.Assertions.assertThat;

import domain.piece.piecerole.BlackPawn;
import domain.piece.piecerole.Queen;
import domain.piece.piecerole.Rook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

    @DisplayName("기물은 기물 종류와 색을 갖는다.")
    @Test
    void generatePiece() {
        Piece piece = new Piece(BlackPawn.create(), BLACK);
        assertThat(piece).isEqualTo(new Piece(BlackPawn.create(), BLACK));
    }

    @DisplayName("하얀색 기물의 색이 하얀색임을 검증한다.")
    @Test
    void checkWhitePiece() {
        Piece piece = new Piece(Queen.create(), WHITE);
        assertThat(piece.isWhite()).isTrue();
    }

    @DisplayName("검은색 기물의 색이 하얀색이 아님을 검증한다.")
    @Test
    void checkBlackPiece() {
        Piece piece = new Piece(Queen.create(), BLACK);
        assertThat(piece.isWhite()).isFalse();
    }

    @DisplayName("기물의 종류가 같음을 검증한다.")
    @Test
    void checkEqualPieceRole() {
        Piece piece = new Piece(Queen.create(), BLACK);

        assertThat(piece.equalPieceRole(Queen.create())).isTrue();
    }

    @DisplayName("기물의 종류가 다름을 검증한다.")
    @Test
    void checkNotEqualPieceRole() {
        Piece piece = new Piece(Queen.create(), BLACK);

        assertThat(piece.equalPieceRole(Rook.create())).isFalse();
    }

    @DisplayName("기물의 종류를 문자열로 반환한다.")
    @Test
    void getPieceRoleName() {
        Piece piece = new Piece(Queen.create(), BLACK);

        assertThat(piece.getPieceRoleName()).isEqualTo("Queen");
    }

    @DisplayName("기물의 색을 문자열로 반환한다.")
    @Test
    void getColorName() {
        Piece piece = new Piece(Queen.create(), BLACK);

        assertThat(piece.getColorName()).isEqualTo("BLACK");
    }
}
