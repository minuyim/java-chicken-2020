package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {
    @Test
    @DisplayName("치킨인지 확인하는 테스트")
    void isChicken() {
        Menu menu = MenuRepository.findByNumber(1);
        assertThat(menu.isChicken()).isTrue();
    }


    @Test
    void calculatePrice() {
        Menu menu = MenuRepository.findByNumber(1);
        assertThat(menu.calculatePrice(new Amount(10))).isEqualTo(160_000);
    }
}