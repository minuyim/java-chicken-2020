package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {
    Table table = TableRepository.findByNumber(1);

    @Test
    void isMenusEmpty() {
        assertThat(table.isMenusEmpty()).isTrue();
    }

    @Test
    @DisplayName("테이블에 메뉴 추가")
    void addMenu() {
        table.addMenu(MenuRepository.findByNumber(1), 1);
        assertThat(table.isMenusEmpty()).isFalse();
    }

    @Test
    void clearMenus() {
        table.addMenu(MenuRepository.findByNumber(1), 1);
        table.clearMenus();
        assertThat(table.isMenusEmpty()).isTrue();
    }

    @Test
    void createOrder() {
        table.addMenu(MenuRepository.findByNumber(1), 1);
        assertThat(table.createOrder()).isNotNull();
    }
}