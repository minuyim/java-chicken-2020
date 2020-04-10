package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentTest {
    @ParameterizedTest
    @MethodSource(value = "providePaymentForCalculate")
    @DisplayName("결제 방식에 맞게 할인하는 지 테스트")
    void calculateDiscount(Payment payment, int value, int expected) {
        assertThat(payment.calculateDiscount(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> providePaymentForCalculate() {
        return Stream.of(
                Arguments.of(Payment.CARD, 100_000, 100_000),
                Arguments.of(Payment.CASH, 100_000, 95_000));
    }

    @ParameterizedTest
    @MethodSource(value = "providePaymentForFind")
    @DisplayName("번호별로 적절한 결제 방식을 가져오는 지 테스트")
    void findByNumber(int value, Payment expected) {
        assertThat(Payment.findByNumber(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> providePaymentForFind() {
        return Stream.of(
                Arguments.of(1, Payment.CARD),
                Arguments.of(2, Payment.CASH));
    }
}