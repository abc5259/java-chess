package chess.domain.square;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("파일")
class FileTest {

    @DisplayName("파일은 8개로 이루어지고, 순서를 유지한다")
    @Test
    void file() {
        //given & when & then
        assertAll(
                () -> assertThat(File.A.ordinal()).isEqualTo(0),
                () -> assertThat(File.B.ordinal()).isEqualTo(1),
                () -> assertThat(File.C.ordinal()).isEqualTo(2),
                () -> assertThat(File.D.ordinal()).isEqualTo(3),
                () -> assertThat(File.E.ordinal()).isEqualTo(4),
                () -> assertThat(File.F.ordinal()).isEqualTo(5),
                () -> assertThat(File.G.ordinal()).isEqualTo(6),
                () -> assertThat(File.H.ordinal()).isEqualTo(7),
                () -> assertThat(File.values()).hasSize(8)
        );
    }

    @DisplayName("문자로 파일을 찾을 수 있다")
    @Test
    void findFile() {
        //given
        String givenFile = "a";

        //when
        File file = File.from(givenFile);

        //then
        assertThat(file).isEqualTo(File.A);
    }

    @DisplayName("유효하지 않은 파일이면 예외가 발생한다")
    @Test
    void invalidFile() {
        //given
        String givenFile = "I";

        //when & then
        assertThatThrownBy(() -> File.from(givenFile))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
