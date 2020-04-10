package domain.price;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {
    @Test
    @DisplayName("음수일 경우 예외처리")
    void constructWithException() {
        assertThatThrownBy(() -> new Price(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가격은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("결제 방식에 따른 최종 결제 가격을 계산할 수 있는 지 테스트")
    void discount() {
        Price price = new Price(100_000);
        assertThat(price.discount(Payment.CASH)).isEqualTo(95_000);
    }
}