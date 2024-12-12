package christmas;

import christmas.domain.Badge;
import christmas.domain.Calendar;
import christmas.domain.Orders;

public class ChristmasService {

    private int presentationCount;
    private int dDayDiscount;
    private int weekdaysDiscount;
    private int weekendsDiscount;
    private int specialDiscount;
    private int presentationPrice;
    private int totalDiscount;
    private int paymentPrice;

    public void discount(int visitDate, Orders orders, int totalPrice) {
        presentationCount = getPresentationCount(totalPrice);
        dDayDiscount = discountDday(visitDate);
        weekdaysDiscount = weekdaysDiscount(visitDate, orders);
        weekendsDiscount = weekendsDiscount(visitDate, orders);
        specialDiscount = specialDiscount(visitDate);
        presentationPrice = getPresentationPrice();
        paymentPrice = totalPrice - totalDiscount;
    }

    private int getTotalDiscount() {
        totalDiscount = 0;
        totalDiscount += dDayDiscount;
        totalDiscount += weekdaysDiscount;
        totalDiscount += weekendsDiscount;
        totalDiscount += specialDiscount;
        totalDiscount += presentationPrice;
        return totalDiscount;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public String getBadge() {
        return Badge.from(totalDiscount).name();
    }

    public int getPresentationPrice() {
        return presentationCount * 25_000;
    }

    private int getPresentationCount(int totalPrice) {
        return totalPrice / 120_000;
    }

    private int discountDday(int visitDate) {
        if (visitDate >= 1 && visitDate <= 25) {
            return 900 + visitDate * 100;
        }
        return 0;
    }

    private int weekdaysDiscount(int visitDate, Orders orders) {
        int weekdaysDiscount = 0;
        if (Calendar.isWeekdays(visitDate)) {
            weekdaysDiscount += orders.getDesertCount() * 2_023;
        }
        return weekdaysDiscount;
    }

    private int weekendsDiscount(int visitDate, Orders orders) {
        int weekendsDiscount = 0;
        if (Calendar.isWeekends(visitDate)) {
            weekendsDiscount += orders.getMainCount() * 2_023;
        }
        return weekendsDiscount;
    }

    private int specialDiscount(int visitDate) {
        if (Calendar.isSpecial(visitDate)) {
            return 1_000;
        }
        return 0;
    }

}
