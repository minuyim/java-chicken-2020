package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TableRepositoryTest {
	@Test
	@DisplayName("Number로 테이블을 찾는 기능 테스트")
	void findById() {
		assertThat(TableRepository.findByNumber(1)).isEqualTo(TableRepository.tables().get(0));
	}

	@Test
	@DisplayName("Number로 메뉴를 찾는 기능 테스트 - 예외처리")
	void findByIdWithException() {
		assertThatThrownBy(() -> TableRepository.findByNumber(0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("해당 번호를 가진 테이블이 없습니다.");
	}
}