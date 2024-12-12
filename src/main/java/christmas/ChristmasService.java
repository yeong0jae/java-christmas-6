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
        if (totalPrice > 10000) {
            presentationCount = getPresentationCount(totalPrice);
            dDayDiscount = discountDday(visitDate);
            weekdaysDiscount = weekdaysDiscount(visitDate, orders);
            weekendsDiscount = weekendsDiscount(visitDate, orders);
            specialDiscount = specialDiscount(visitDate);
            presentationPrice = getPresentationPrice();
            totalDiscount = getTotalDiscount();
            paymentPrice = totalPrice - totalDiscount + presentationPrice;
        }
    }

    public int getDdayDiscount() {
        return dDayDiscount;
    }

    public int getWeekdaysDiscount() {
        return weekdaysDiscount;
    }

    public int getWeekendsDiscount() {
        return weekendsDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getTotalDiscount() {
        totalDiscount = 0;
        totalDiscount += dDayDiscount;
        totalDiscount += weekdaysDiscount;
        totalDiscount += weekendsDiscount;
        totalDiscount += specialDiscount;
        totalDiscount += presentationPrice;
        return totalDiscount;
    }

    public boolean isNoDiscount() {
        return totalDiscount == 0;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public String getBadge() {
        return Badge.from(totalDiscount).getName();
    }

    public int getPresentationPrice() {
        return presentationCount * 25_000;
    }

    public int getPresentationCount(int totalPrice) {
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
