package christmas.domain;

import christmas.util.ErrorMessage;

public class Order {

    private final String name;
    private final int count;

    public Order(String name, int count) {
        validateCount(count);
        validateName(name);
        this.name = name;
        this.count = count;
    }

    public void validateName(String name) {
        if (!Menu.isIn(name)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public int getTotalPrice() {
        return Menu.getPrice(name) * count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int isDesert() {
        if (Menu.isDessert(name)) {
            return count;
        }
        return 0;
    }

    public int isMain() {
        if (Menu.isMain(name)) {
            return count;
        }
        return 0;
    }
}
