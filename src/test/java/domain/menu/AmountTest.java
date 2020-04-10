package domain.menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @Test
    @DisplayName("Amount 생성 테스트")
    void construct() {
        Assertions.assertThat(new Amount(10)).isNotNull();
    }

    @Test
    @DisplayName("Amount 최대 초과 시 예외처리")
    void constructWithExceptionNegative() {
        assertThatThrownBy(() -> new Amount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수량은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("Amount 최대 초과 시 예외처리")
    void constructWithException() {
        assertThatThrownBy(() -> new Amount(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 수량을 넘겼습니다.");
    }

    @Test
    @DisplayName("int 더하기 테스트")
    void add() {
        Amount amount = new Amount(10);
        assertThat(amount.add(10)).isEqualTo(new Amount(20));
    }

    @Test
    @DisplayName("Amount 덧셈 테스트")
    void sum() {
        Amount amount1 = new Amount(10);
        Amount amount2 = new Amount(20);
        assertThat(Amount.sum(amount1, amount2)).isEqualTo(new Amount(30));
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply() {
        Amount amount = new Amount(10);
        assertThat(amount.multiply(1000)).isEqualTo(10000);
    }
}