package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
	@Test
	@DisplayName("치킨인지 확인하는 테스트")
	void isChicken() {
		Menu menu = MenuRepository.findByNumber(1);
		assertThat(menu.isChicken()).isTrue();
	}
}