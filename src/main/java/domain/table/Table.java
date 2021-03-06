package domain.table;

import domain.menu.Menu;
import domain.menu.Menus;
import domain.order.Order;

public class Table {
    private final int number;
    private Menus menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new Menus();
    }

    public void addMenu(Menu menu, int amount) {
        menus.addMenu(menu, amount);
    }

    public void clearMenus() {
        menus.clear();
    }

    public boolean isMenusEmpty() {
        return menus.isEmpty();
    }

    public Order createOrder() {
        return menus.createOrder();
    }

    public boolean matchNumber(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }

    public Menus getMenus() {
        return menus;
    }
}
