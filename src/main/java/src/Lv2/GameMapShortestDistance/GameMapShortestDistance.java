package src.Lv2.GameMapShortestDistance;

import java.util.*;

public class GameMapShortestDistance {
    public static void main(String[] args) {

        int[][][] testCases = {
                {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}},
                {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}}
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solution(testCases[i]);
            System.out.println(result);
        }
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0 , 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        maps[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}
