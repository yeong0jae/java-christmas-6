package christmas;

import christmas.domain.Calendar;
import christmas.domain.Orders;

public class ChristmasService {

    public int getPresentation(int totalPrice) {
        return totalPrice / 120000;
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
}
