package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Menus {
    private Map<Menu, Amount> menus;

    public Menus() {
        this.menus = new HashMap<>();
    }

    public void addMenu(Menu menu, int value) {
        if (menus.containsKey(menu)) {
            menus.computeIfPresent(menu, ((menu1, amount) -> amount.add(value)));
        }
        menus.putIfAbsent(menu, new Amount(value));
    }

    public void clear() {
        menus.clear();
    }

    public boolean isEmpty() {
        return menus.keySet().isEmpty();
    }

    public Order createOrder() {
        return new Order(menus);
    }

    public Map<Menu, Amount> getMenus() {
        return Collections.unmodifiableMap(menus);
    }
}
