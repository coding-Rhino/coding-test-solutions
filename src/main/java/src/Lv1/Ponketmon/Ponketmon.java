package src.Lv1.Ponketmon;

import java.util.*;

public class Ponketmon {
    public static void main(String[] args) {
        int[][] testCases = {
                {3, 1, 2, 3},
                {3, 3, 3, 2, 2, 4},
                {3, 3, 3, 2, 2, 2}
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solution(testCases[i]);
            System.out.println(result);
        }
    }

    public static int solution(int[] nums) {
        // 선택할 수 있는 최대 폰켓몬 수
        int max = nums.length / 2;

        // 중복 제거를 위한 Set 사용
        Set<Integer> number = new HashSet<>();
        for (int num : nums) {
            number.add(num);
        }

        // 중복을 제거한 종류 수와 최대 선택 수 중 작은 값을 반환
        return Math.min(max, number.size());
    }
}
