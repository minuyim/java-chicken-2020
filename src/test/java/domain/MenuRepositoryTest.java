package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {
    @Test
    @DisplayName("Number로 메뉴를 찾는 기능 테스트")
    void findById() {
        assertThat(MenuRepository.findByNumber(1)).isEqualTo(MenuRepository.menus().get(0));
    }

    @Test
    @DisplayName("Number로 메뉴를 찾는 기능 테스트 - 예외처리")
    void findByIdWithException() {
        assertThatThrownBy(() -> MenuRepository.findByNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 번호를 가진 메뉴가 없습니다.");
    }
}