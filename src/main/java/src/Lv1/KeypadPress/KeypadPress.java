package src.Lv1.KeypadPress;

public class KeypadPress {
    public static void main(String[] args) {
        int[][] testNumbers = {
                {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        };
        String[] testHands = {"right", "left", "right"};

        for (int t = 0; t < testNumbers.length; t++) {
            int[] numbers = testNumbers[t];
            String hand = testHands[t];

            String answer = "";
            int leftHand = 10;
            int rightHand = 12;
            int leftRange = 0;
            int rightRange = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) numbers[i] = 11;

                if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                    leftHand = numbers[i];
                    answer += "L";
                } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                    rightHand = numbers[i];
                    answer += "R";
                } else {
                    leftRange = (Math.abs(leftHand - numbers[i]) / 3) + (Math.abs(leftHand - numbers[i]) % 3);
                    rightRange = (Math.abs(rightHand - numbers[i]) / 3) + (Math.abs(rightHand - numbers[i]) % 3);
                    if (leftRange == rightRange) {
                        if (hand.equals("left")) {
                            leftHand = numbers[i];
                            answer += "L";
                        } else {
                            rightHand = numbers[i];
                            answer += "R";
                        }
                    } else if (leftRange < rightRange) {
                        leftHand = numbers[i];
                        answer += "L";
                    } else {
                        rightHand = numbers[i];
                        answer += "R";
                    }
                }
            }

            System.out.println(t + 1 + ": " + answer);
        }
    }
}
