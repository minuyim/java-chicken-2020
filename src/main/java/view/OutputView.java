package view;

import dto.MenuDto;
import dto.MenuWithAmountDto;
import dto.TableDto;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_WITH_WON = "└ " + Currency.getInstance(Locale.KOREA).getSymbol() + " ┘";

    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static void printTables(final List<TableDto> tableDtos) {
        System.out.println("## 테이블 목록");
        final int size = tableDtos.size();
        printLine(size);
        printTableNumbers(tableDtos);
        printBottomLine(tableDtos);
    }

    public static void printMenus(final List<MenuDto> menuDtos) {
        for (MenuDto menuDto : menuDtos) {
            System.out.println(String.format("[%s] %d - %s : %d원",
                    menuDto.getCategory(), menuDto.getNumber(), menuDto.getName(), menuDto.getPrice()));
        }
    }

    private static void printLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<TableDto> tableDtos) {
        for (final TableDto tableDto : tableDtos) {
            List<MenuWithAmountDto> menuWithAmountDtos = tableDto.getMenuWithAmountDtos();
            printBottomLineByTable(menuWithAmountDtos, tableDto.getNumber());
        }
        System.out.println();
    }

    private static void printBottomLineByTable(List<MenuWithAmountDto> menuWithAmountDtos, int number) {
        if (menuWithAmountDtos.isEmpty()) {
            System.out.print(BOTTOM_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE_WITH_WON);
    }

    private static void printTableNumbers(final List<TableDto> tableDtos) {
        for (final TableDto tableDto : tableDtos) {
            System.out.printf(TABLE_FORMAT, tableDto.getNumber());
        }
        System.out.println();
    }

    public static void printOrder(TableDto tableDto) {
        System.out.println("## 주문내역");
        System.out.println("메뉴 수량 금액");
        for (MenuWithAmountDto menuWithAmountDto : tableDto.getMenuWithAmountDtos()) {
            System.out.println(String.format("%s %d %d",
                    menuWithAmountDto.getName(), menuWithAmountDto.getAmount(), menuWithAmountDto.getPrice()));
        }
        System.out.println();
        System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", tableDto.getNumber()));
    }

    public static void printPrice(int price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(String.format("%d원", price));
    }
}
