package src.Lv2.HanoiTop;

import java.util.*;

public class HanoiTop {

    public static void main(String[] args) {

        int[][] hanoi = {{1, 3}};
        int n = 2;

        int[][] answer = Hanoi(n, 1, hanoi);

        for (int[] index : answer) {
            System.out.println(Arrays.toString(index));
        }
    }

    public static int[][] Hanoi(int n, int index, int[][] beforeHanoi) {
        int size = (int) (Math.pow(2, n) - 1);
        int[][] currentHanoi = new int[size][2];

        if (index > n) {
            return beforeHanoi;
        }

        if (index == 1) {
            currentHanoi[0][0] = 1;
            currentHanoi[0][1] = 3;
        } else {
            for (int i = 0; i < beforeHanoi.length; i++) {
                boolean isChange = false;

                if (beforeHanoi[i][0] == 2) {
                    currentHanoi[i][0] = 3;
                    currentHanoi[i][1] = beforeHanoi[i][1];
                    isChange = true;
                } else if (beforeHanoi[i][0] == 3) {
                    currentHanoi[i][0] = 2;
                    currentHanoi[i][1] = beforeHanoi[i][1];
                    isChange = true;
                }

                if (beforeHanoi[i][1] == 2) {
                    currentHanoi[i][0] = (isChange) ? currentHanoi[i][0] : beforeHanoi[i][0];
                    currentHanoi[i][1] = 3;
                } else if (beforeHanoi[i][1] == 3) {
                    currentHanoi[i][0] = (isChange) ? currentHanoi[i][0] : beforeHanoi[i][0];
                    currentHanoi[i][1] = 2;
                }
            }

            currentHanoi[(int)(Math.pow(2, index - 1)) - 1][0] = 1;
            currentHanoi[(int)(Math.pow(2, index - 1)) - 1][1] = 3;

            for (int i = 0; i < beforeHanoi.length; i++) {
                boolean isChange = false;
                if (beforeHanoi[i][0] == 1) {
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][0] = 2;
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][1] = beforeHanoi[i][1];
                    isChange = true;
                } else if (beforeHanoi[i][0] == 2) {
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][0] = 1;
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][1] = beforeHanoi[i][1];
                    isChange = true;
                }

                if (beforeHanoi[i][1] == 1) {
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][0] = (isChange) ? currentHanoi[(int)(Math.pow(2, index - 1)) + i][0] : beforeHanoi[i][0];
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][1] = 2;
                } else if (beforeHanoi[i][1] == 2) {
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][0] = (isChange) ? currentHanoi[(int)(Math.pow(2, index - 1)) + i][0] : beforeHanoi[i][0];
                    currentHanoi[(int)(Math.pow(2, index - 1)) + i][1] = 1;
                }
            }
        }

        if (index == n) {
            return currentHanoi;
        } else {
            return Hanoi(n, index + 1, currentHanoi);
        }
    }
}
