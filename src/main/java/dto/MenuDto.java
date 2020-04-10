package dto;

import domain.menu.Menu;

import java.util.List;
import java.util.stream.Collectors;

public class MenuDto {
    private String name;
    private String category;
    private int number;
    private int price;

    public MenuDto(String name, String category, int number, int price) {
        this.name = name;
        this.category = category;
        this.number = number;
        this.price = price;
    }

    public static MenuDto of(Menu menu) {
        return new MenuDto(menu.getName(), menu.getCategoryName(), menu.getNumber(), menu.getPrice());
    }

    public static List<MenuDto> of(List<Menu> menus) {
        return menus.stream()
                .map(MenuDto::of)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }
}
