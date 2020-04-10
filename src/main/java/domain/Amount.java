package domain;

import java.util.Objects;

public class Amount {
	private static final int MAX_AMOUNT = 99;
	private int amount;

	public Amount(int amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(int amount) {
		if (amount > MAX_AMOUNT) {
			throw new IllegalArgumentException("최대 수량을 넘겼습니다.");
		}
	}

	public Amount add(int amount) {
		return new Amount(this.amount + amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Amount amount1 = (Amount) o;
		return amount == amount1.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
