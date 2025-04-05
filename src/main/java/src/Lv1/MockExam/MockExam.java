package src.Lv1.MockExam;

import java.util.*;

public class MockExam {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3, 4, 5},
                {1, 3, 2, 4, 2}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] result = solution(testCases[i]);
            System.out.println(Arrays.toString(result));
        }
    }

    public static int[] solution(int[] answers) {
        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answer1Count = 0;
        int answer2Count = 0;
        int answer3Count = 0;

        for (int i = 0; i < answers.length; i++) {
            if (supoja1[i % supoja1.length] == answers[i]) answer1Count++;
            if (supoja2[i % supoja2.length] == answers[i]) answer2Count++;
            if (supoja3[i % supoja3.length] == answers[i]) answer3Count++;
        }

        int max = Math.max(answer1Count, Math.max(answer2Count, answer3Count));

        int[] temp = new int[3];
        int idx = 0;

        if (answer1Count == max) temp[idx++] = 1;
        if (answer2Count == max) temp[idx++] = 2;
        if (answer3Count == max) temp[idx++] = 3;

        return Arrays.copyOf(temp, idx);
    }
}
