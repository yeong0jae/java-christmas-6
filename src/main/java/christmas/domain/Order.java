package christmas.domain;

public class Order {

    private final String name;
    private final int count;

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
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
