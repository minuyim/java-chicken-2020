package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.price.Payment;
import domain.price.Price;
import domain.table.Table;
import domain.table.TableRepository;
import dto.MenuDto;
import dto.TableDto;
import view.InputView;
import view.OutputView;

public class ChickenController {
    public void run() {
        OutputView.printMain();
        Command command = Command.findByNumber(InputView.inputCommandNumber());
        if (command.isOrder()) {
            order();
        }
        if (command.isPay()) {
            pay();
        }
    }

    private void order() {
        OutputView.printTables(TableDto.of(TableRepository.tables()));
        Table table = TableRepository.findByNumber(InputView.inputTableNumber());

        OutputView.printMenus(MenuDto.of(MenuRepository.menus()));
        Menu menu = MenuRepository.findByNumber(InputView.inputMenuNumber());
        table.addMenu(menu, InputView.inputAmountNumber());
    }

    private void pay() {
        OutputView.printTables(TableDto.of(TableRepository.tables()));
        Table table = TableRepository.findByNumber(InputView.inputTableNumber());

        OutputView.printOrder(TableDto.of(table));
        Payment payment = Payment.findByNumber(InputView.inputPaymentNumber());
        Order order = table.createOrder();
        Price price = order.calculatePrice();

        OutputView.printPrice(price.calculateAfterDiscount(payment));
        table.clearMenus();
    }
}
