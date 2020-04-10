package domain.menu;

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
        if (amount < 0) {
            throw new IllegalArgumentException("수량은 음수가 될 수 없습니다.");
        }
    }

    public static Amount sum(Amount amount1, Amount amount2) {
        return new Amount(amount1.amount + amount2.amount);
    }

    public Amount add(int amount) {
        return new Amount(this.amount + amount);
    }

    public int multiply(int price) {
        return price * amount;
    }

    public int divide(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0 이상의 값을 입력해주세요");
        }
        return amount / number;
    }

    public int getAmount() {
        return amount;
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
