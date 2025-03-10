package src.Lv2.BiggestNumber;

import java.util.*;

public class BiggestNumber {
    public static void main(String[] args) {
        int[][] numbers = {
                {6, 10, 2},
                {3, 30, 34, 5, 9}
        };

        for (int[] number : numbers) {
            System.out.println("number: " + Arrays.toString(number));
            String result = solution(number);  // static 메서드 직접 호출
            System.out.println("return: " + result);
            System.out.println();
        }
    }

    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>();

        for (int num : numbers) {
            list.add(String.valueOf(num));
        }

        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

        if (list.get(0).equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String num : list) {
            answer.append(num);
        }

        return answer.toString();
    }
}
