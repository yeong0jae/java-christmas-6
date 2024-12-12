package christmas.view;

import christmas.domain.Order;
import java.util.List;

public class OutputView {

    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrders(List<Order> orders) {
        System.out.println("<주문 메뉴>");
        orders.forEach(order ->
                System.out.println(order.getName() + " " + order.getCount() + "개")
        );
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPrice + "원");
        System.out.println();
    }

    public void printPresentation(int presentation) {
        System.out.println("<증정 메뉴>");
        if (presentation == 0) {
            System.out.println("없음");
        } else {
            System.out.println("샴페인 " + presentation + "개");
        }
        System.out.println();
    }
}
