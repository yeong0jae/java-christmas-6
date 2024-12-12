package christmas.domain;

import christmas.util.ErrorMessage;
import java.util.List;

public enum Calendar {
    WEEKDAYS(List.of(
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    )),
    WEEKENDS(List.of(1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    )),
    SPECIAL(List.of(3, 10, 17, 24, 25, 31));

    private final List<Integer> days;

    Calendar(List<Integer> days) {
        this.days = days;
    }

    public static void isIn(int visitDate) {
        if (visitDate < 1 || visitDate > 31) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static boolean isWeekdays(int visitDate) {
        return valueOf("WEEKDAYS").days.stream()
                .anyMatch(day -> day == visitDate);
    }
}
