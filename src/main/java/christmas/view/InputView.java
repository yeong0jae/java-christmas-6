package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int readVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String rawInput = Console.readLine();
        if (!rawInput.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + "유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return Integer.parseInt(rawInput);
    }

    public List<String> readOrders() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String rawInput = Console.readLine();
        return Arrays.stream(rawInput.split(",")).toList();
    }
}
