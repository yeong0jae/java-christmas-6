package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum Menu {

    APPETIZER(List.of(
            Map.of("양송이 스프", 6_000),
            Map.of("타파스", 5_500),
            Map.of("시저샐러드", 8_000)
    )),
    MAIN(List.of(
            Map.of("티본스테이크", 55_000),
            Map.of("바비큐립", 54_000),
            Map.of("해산물파스타", 35_000),
            Map.of("크리스마스파스타", 25_000)
    )),
    DESSERT(List.of(
            Map.of("초코케이크", 15_000),
            Map.of("아이스크림", 5_000)
    )),
    DRINK(List.of(
            Map.of("제로콜라", 3_000),
            Map.of("레드와인", 60_000),
            Map.of("샴페인", 25_000)
    ));

    private List<Map<String, Integer>> menu;

    Menu(List<Map<String, Integer>> menu) {
        this.menu = menu;
    }

    public static int getPrice(String name) {
        return Arrays.stream(Menu.values())
                .flatMap(menu -> menu.menu.stream())
                .filter(map -> map.containsKey(name))
                .map(map -> map.get(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 메뉴입니다. 다시 입력해 주세요."));
    }
}
