package christmas;

import christmas.domain.Calendar;
import christmas.domain.Orders;

public class ChristmasService {

    private int presentationCount;
    private int dDayDiscount;
    private int weekdaysDiscount;
    private int weekendsDiscount;
    private int specialDiscount;
    private int presentationPrice;

    public void discount(int visitDate, Orders orders, int totalPrice) {
        presentationCount = getPresentationCount(totalPrice);
        dDayDiscount = discountDday(visitDate);
        weekdaysDiscount = weekdaysDiscount(visitDate, orders);
        weekendsDiscount = weekendsDiscount(visitDate, orders);
        specialDiscount = specialDiscount(visitDate);
        presentationPrice = getPresentationPrice();
    }

    public int getPresentationCount(int totalPrice) {
        return totalPrice / 120_000;
    }

    public int getPresentationPrice() {
        return presentationCount * 25_000;
    }

    public int discountDday(int visitDate) {
        if (visitDate >= 1 && visitDate <= 25) {
            return 900 + visitDate * 100;
        }
        return 0;
    }

    public int weekdaysDiscount(int visitDate, Orders orders) {
        int weekdaysDiscount = 0;
        if (Calendar.isWeekdays(visitDate)) {
            weekdaysDiscount += orders.getDesertCount() * 2_023;
        }
        return weekdaysDiscount;
    }

    public int weekendsDiscount(int visitDate, Orders orders) {
        int weekendsDiscount = 0;
        if (Calendar.isWeekends(visitDate)) {
            weekendsDiscount += orders.getMainCount() * 2_023;
        }
        return weekendsDiscount;
    }

    public int specialDiscount(int visitDate) {
        if (Calendar.isSpecial(visitDate)) {
            return 1_000;
        }
        return 0;
    }


}
