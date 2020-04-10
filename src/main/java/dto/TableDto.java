package dto;

import domain.table.Table;

import java.util.List;
import java.util.stream.Collectors;

public class TableDto {
    private int number;
    private List<MenuWithAmountDto> menuWithAmountDtos;

    public TableDto(int number, List<MenuWithAmountDto> menuWithAmountDtos) {
        this.number = number;
        this.menuWithAmountDtos = menuWithAmountDtos;
    }

    public static TableDto of(Table table) {
        return new TableDto(table.getNumber(), MenuWithAmountDto.of(table.getMenus()));
    }

    public static List<TableDto> of(List<Table> tables) {
        return tables.stream()
                .map(TableDto::of)
                .collect(Collectors.toList());
    }


    public int getNumber() {
        return number;
    }

    public List<MenuWithAmountDto> getMenuWithAmountDtos() {
        return menuWithAmountDtos;
    }
}
