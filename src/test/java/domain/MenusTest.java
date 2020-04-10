package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenusTest {
    private Menus menus = new Menus();

    @Test
    @DisplayName("메뉴를 수량만큼 더한다.")
    void addMenu() {
        menus.addMenu(MenuRepository.findByNumber(1), 1);
        assertThat(menus.getMenus().getOrDefault(MenuRepository.findByNumber(1), null)).isEqualTo(new Amount(1));
    }

    @Test
    @DisplayName("주문 내역이 비었는지 확인")
    void isEmpty() {
        assertThat(menus.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("메뉴판 비우기")
    void clear() {
        menus.addMenu(MenuRepository.findByNumber(1), 1);
        menus.clear();
        assertThat(menus.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Order 객체 생성")
    void createOrder() {
        menus.addMenu(MenuRepository.findByNumber(1), 1);
        assertThat(menus.createOrder()).isNotNull();
    }
}