package domain.price;

import java.util.Objects;

public class Price {
    private int price;

    public Price(int price) {
        validateNegative(price);
        this.price = price;
    }

    private void validateNegative(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다.");
        }
    }

    public int calculateAfterDiscount(Payment payment) {
        return (int) payment.calculateDiscount(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
