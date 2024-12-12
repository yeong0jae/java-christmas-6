package christmas;

public class ChristmasService {

    public int getPresentation(int totalPrice) {
        return totalPrice / 120000;
    }

    public void discount() {
    }

    public int discountDday(int visitDate) {
        if (visitDate >= 1 && visitDate <= 25) {
            return 900 + visitDate * 100;
        }
        return 0;
    }
}
