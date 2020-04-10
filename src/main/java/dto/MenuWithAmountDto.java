package dto;

import domain.menu.Amount;
import domain.menu.Menu;
import domain.menu.Menus;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuWithAmountDto {
    private String name;
    private int amount;
    private int price;

    public MenuWithAmountDto(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public static MenuWithAmountDto of(Menu menu, Amount amount) {
        return new MenuWithAmountDto(menu.getName(), amount.getAmount(), menu.getPrice());
    }

    public static List<MenuWithAmountDto> of(Menus menus) {
        Map<Menu, Amount> menuAndAmount = menus.getMenus();
        return menuAndAmount.keySet()
                .stream()
                .map(menu -> MenuWithAmountDto.of(menu, menuAndAmount.get(menu)))
                .collect(Collectors.toList());
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
