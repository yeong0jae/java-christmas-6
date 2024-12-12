package christmas;

import christmas.domain.Calendar;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

        retryUntilValid(() -> {
            int visitDate = inputView.readVisitDate();
            Calendar.isIn(visitDate);
        });

        List<String> inputOrders = inputView.readOrders();
        Orders orders = new Orders(inputOrders);
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
