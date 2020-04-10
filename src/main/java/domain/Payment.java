package domain;

import java.util.Arrays;

public enum Payment {
    CARD(1, 0),
    CASH(2, 0.05);

    private int number;
    private double discountRate;

    Payment(int number, double discountRate) {
        this.number = number;
        this.discountRate = discountRate;
    }

    public double calculateDiscount(int price) {
        return price * (1 - discountRate);
    }

    public static Payment findByNumber(int number) {
        return Arrays.stream(values())
                .filter(payment -> payment.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 결제 방식이 존재하지 않습니다."));
    }
}
