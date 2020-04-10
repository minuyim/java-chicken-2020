package domain;

import java.util.Map;
import java.util.Objects;

public class Order {
    private static final int DISCOUNT_PRICE = 10000;
    private static final int DISCOUNT_AMOUNT = 10;
    private Map<Menu, Amount> order;

    public Order(Map<Menu, Amount> order) {
        validate(order);
        this.order = order;
    }

    private void validate(Map<Menu, Amount> order) {
        if (Objects.isNull(order) || order.isEmpty()) {
            throw new IllegalArgumentException("주문 목록이 비어있습니다.");
        }
    }

    public int calculatePrice() {
        return calculateRawPrice() - calculateDiscountPrice();
    }

    private int calculateRawPrice() {
        return order.keySet().stream()
                .mapToInt(menu -> menu.calculatePrice(order.getOrDefault(menu, new Amount(0))))
                .sum();
    }

    private int calculateDiscountPrice() {
        return countChickenAmount().divide(DISCOUNT_AMOUNT) * DISCOUNT_PRICE;
    }

    private Amount countChickenAmount() {
        return order.keySet().stream()
                .filter(Menu::isChicken)
                .map(menu -> order.get(menu))
                .reduce(new Amount(0), Amount::sum);
    }
}
