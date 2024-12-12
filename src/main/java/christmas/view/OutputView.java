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

    public void printDiscount(int ddayDiscount, int weekdaysDiscount, int weekendsDiscount, int specialDiscount,
                              int presentationPrice, boolean noDiscount, String badge) {
        printPresentationMenu(presentationPrice);
        printDiscountInfo(ddayDiscount, weekdaysDiscount, weekendsDiscount, specialDiscount, presentationPrice,
                noDiscount);
        printTotalDiscount(ddayDiscount, weekdaysDiscount, weekendsDiscount, specialDiscount, presentationPrice);
    }

    private void printTotalDiscount(int ddayDiscount, int weekdaysDiscount, int weekendsDiscount, int specialDiscount,
                                    int presentationPrice) {
        System.out.println("<총혜택 금액>");
        int totalDiscount = ddayDiscount + weekdaysDiscount + weekendsDiscount + specialDiscount + presentationPrice;
        System.out.println(
                "-" + totalDiscount + "원");
        System.out.println();
    }

    private void printPresentationMenu(int presentationPrice) {
        System.out.println("<증정 메뉴>");
        int presentationCount = presentationPrice / 25_000;
        if (presentationCount < 1) {
            System.out.println("없음");
        } else {
            System.out.println("샴페인 " + presentationCount + "개");
        }
        System.out.println();
    }

    private void printDiscountInfo(int ddayDiscount, int weekdaysDiscount, int weekendsDiscount, int specialDiscount,
                                   int presentationPrice, boolean noDiscount) {
        System.out.println("<혜택 내역>");
        if (!noDiscount) {
            if (ddayDiscount > 0) {
                System.out.println("크리스마스 디데이 할인: " + "-" + ddayDiscount + "원");
            }
            if (weekdaysDiscount > 0) {
                System.out.println("평일 할인: " + "-" + weekdaysDiscount + "원");
            }
            if (weekendsDiscount > 0) {
                System.out.println("주말 할인: " + "-" + weekendsDiscount + "원");
            }
            if (specialDiscount > 0) {
                System.out.println("특별 할인: " + "-" + specialDiscount + "원");
            }
            if (presentationPrice > 0) {
                System.out.println("증정 이벤트: " + "-" + presentationPrice + "원");
            }
        } else {
            System.out.println("없음");
        }
        System.out.println();
    }


}
