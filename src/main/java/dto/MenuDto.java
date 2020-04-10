package dto;

import domain.menu.Menu;

public class MenuDto {
    private String name;
    private int amount;
    private int price;

    public MenuDto(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public MenuDto of(Menu menu) {
        return new MenuDto(menu.getName(), menu.getNumber(), menu.getPrice());
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
