package domain.order;

import domain.menu.MenuRepository;
import domain.menu.Menus;
import domain.price.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    @Test
    @DisplayName("주문 목록이 빌 경우 예외 처리")
    void constructWithException() {
        Menus menus = new Menus();
        assertThatThrownBy(menus::createOrder)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 목록이 비어있습니다.");
    }

    @Test
    @DisplayName("할인 정책에 맞는 가격 표시")
    void calculatePrice() {
        Menus menus = new Menus();
        menus.addMenu(MenuRepository.findByNumber(1), 10);
        Order order = menus.createOrder();
        assertThat(order.calculatePrice()).isEqualTo(new Price(150_000));
    }
}