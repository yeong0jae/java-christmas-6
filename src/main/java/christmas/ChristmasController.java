package christmas;

import christmas.domain.Calendar;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ChristmasService christmasService = new ChristmasService();

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

        int visitDate = visit();

        Orders orders = order();
        outputView.printOrders(orders.getOrders());

        int totalPrice = orders.getTotalPrice();
        outputView.printTotalPrice(totalPrice);

        discount(visitDate, orders, totalPrice);
    }

    private int visit() {
        return retryUntilValid(() -> {
            int date = inputView.readVisitDate();
            Calendar.isIn(date);
            return date;
        });
    }

    private Orders order() {
        Orders orders = retryUntilValid(() -> {
            List<String> inputOrders = inputView.readOrders();
            return new Orders(inputOrders);
        });
        return orders;
    }

    private void discount(int visitDate, Orders orders, int totalPrice) {
        christmasService.discount(visitDate, orders, totalPrice);

        outputView.printDiscount(
                christmasService.getDdayDiscount(),
                christmasService.getWeekdaysDiscount(),
                christmasService.getWeekendsDiscount(),
                christmasService.getSpecialDiscount(),
                christmasService.getPresentationPrice(),
                christmasService.isNoDiscount(),
                christmasService.getBadge()
        );
        outputView.printPaymentPrice(christmasService.getPaymentPrice());
        outputView.printBadge(christmasService.getBadge());
    }

    private static <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
