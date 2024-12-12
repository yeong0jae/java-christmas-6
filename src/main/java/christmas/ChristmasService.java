package christmas;

import christmas.domain.Calendar;
import christmas.domain.Orders;

public class ChristmasService {

    public int getPresentation(int totalPrice) {
        return totalPrice / 120_000;
    }

    public int getPresentationPrice(int presentation) {
        return presentation * 25_000;
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
