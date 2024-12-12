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

        int visitDate = retryUntilValid(() -> {
            int date = inputView.readVisitDate();
            Calendar.isIn(date);
            return date;
        });

        Orders orders = retryUntilValid(() -> {
            List<String> inputOrders = inputView.readOrders();
            return new Orders(inputOrders);
        });
        outputView.printOrders(orders.getOrders());

        int totalPrice = orders.getTotalPrice();
        outputView.printTotalPrice(totalPrice);

        int presentation = christmasService.getPresentation(totalPrice);
        outputView.printPresentation(presentation);

        int dDayDiscount = christmasService.discountDday(visitDate);
        
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

    private static void retryUntilValid(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
