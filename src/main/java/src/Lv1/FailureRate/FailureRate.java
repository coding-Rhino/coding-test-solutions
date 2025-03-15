package src.Lv1.FailureRate;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
        int[][] testCases = {
                {5, 2, 1, 2, 6, 2, 4, 3, 3},
                {4, 4, 4, 4, 4, 4}
        };

        for (int[] testCase : testCases) {
            int N = testCase[0];
            int[] stages = Arrays.copyOfRange(testCase, 1, testCase.length);

            System.out.println(Arrays.toString(solution(N, stages)));
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> failureRate = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int reached = 0;
            int failed = 0;

            for (int stage : stages) {
                if (stage >= i) reached++;
                if (stage == i) failed++;
            }

            failureRate.put(i, reached == 0 ? 0.0 : (double) failed / reached);
        }

        List<Integer> sortedStages = new ArrayList<>(failureRate.keySet());
        sortedStages.sort((a, b) -> failureRate.get(b).compareTo(failureRate.get(a)));

        for (int i = 0; i < N; i++) {
            answer[i] = sortedStages.get(i);
        }

        return answer;
    }

}
