package src.Lv2.FindNextGreaterNumber;

import java.util.*;

public class FindNextGreaterNumber {
    public static void main(String[] args) {
        int[][] testCases = {
                {2, 3, 3, 5},
                {9, 1, 5, 3, 6, 2}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] result = solution(testCases[i]);
            System.out.println(Arrays.toString(result));
        }
    }

    public static int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }

            stack.push(numbers[i]);
        }

        return answer;
    }
}
