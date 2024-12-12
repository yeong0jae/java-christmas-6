package christmas.domain;

import christmas.util.ErrorMessage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Orders {

    private final List<Order> orders;

    public Orders(List<String> orders) {
        this.orders = orders.stream()
                .map(order -> {
                    List<String> map = Arrays.stream(order.split("-")).toList();
                    validateCount(map.get(1));
                    return new Order(map.get(0), Integer.parseInt(map.get(1)));
                }).toList();
        validateMaxCount(this.orders);
        validateDuplicateMenu(this.orders);
        validateOnlyDrink(this.orders);
    }

    private void validateOnlyDrink(List<Order> orders) {
        List<String> orderNames = orders.stream()
                .map(order -> order.getName())
                .toList();
        if (orderNames.stream()
                .allMatch(name -> Menu.isDrink(name))) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateDuplicateMenu(List<Order> orders) {
        List<String> orderNames = orders.stream()
                .map(order -> order.getName())
                .toList();
        if (orderNames.stream()
                .anyMatch(order -> Collections.frequency(orderNames, order) >= 2)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateMaxCount(List<Order> orders) {
        int totalCount = orders.stream()
                .mapToInt(Order::getCount)
                .sum();
        if (totalCount > 20) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateCount(String count) {
        if (!count.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public int getTotalPrice() {
        return orders.stream()
                .mapToInt(Order::getTotalPrice)
                .sum();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getDesertCount() {
        return orders.stream()
                .mapToInt(Order::isDesert)
                .sum();
    }

    public int getMainCount() {
        return orders.stream()
                .mapToInt(Order::isMain)
                .sum();
    }
}
