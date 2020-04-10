package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
	@Test
	@DisplayName("Amount 생성 테스트")
	void construct() {
		assertThat(new Amount(10)).isNotNull();
	}

	@Test
	@DisplayName("Amount 최대 초과 시 예외처리")
	void constructWithException() {
		assertThatThrownBy(() -> new Amount(100))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("최대 수량을 넘겼습니다.");
	}

	@Test
	void add() {
		Amount amount = new Amount(10);
		assertThat(amount.add(10)).isEqualTo(new Amount(20));
	}
}