package src.Lv2.TargetNumber;

public class TargetNumber {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 1, 1, 1, 1},
                {4, 1, 2, 1}
        };
        int[] targets = {3, 4};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(dfs(testCases[i], targets[i], 0, 0));
        }
    }

    public static int dfs(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        return dfs(numbers, target, sum + numbers[index], index + 1) +
                dfs(numbers, target, sum - numbers[index], index + 1);
    }
}
