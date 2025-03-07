package src.Lv1.MostReceivedGift;

import java.util.Arrays;
import java.util.Objects;

public class MostReceivedGift {
    public static void main(String[] args) {

        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int answer = 0;
        int[][] friendsArray = new int[friends.length][friends.length];
        String[][] giftsArray = new String[gifts.length][];
        int[] givingGift = new int[friends.length];
        int[] gettingGift = new int[friends.length];
        int[] indexGift = new int[friends.length];
        int[] predictionGift = new int[friends.length];

        for (int i = 0; i < giftsArray.length; i++) {
            giftsArray[i] = gifts[i].split(" ");
        }

        for (int i = 0; i < giftsArray.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (Objects.equals(giftsArray[i][0], friends[j])) {
                    for (int k = 0; k < friends.length; k++) {
                        if (Objects.equals(giftsArray[i][1], friends[k])) {
                            friendsArray[j][k]++;
                            gettingGift[k]++;
                        }
                    }
                    givingGift[j]++;
                }
            }
        }

        for (int i = 0; i < indexGift.length; i++) {
            indexGift[i] = givingGift[i] - gettingGift[i];
        }

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i != j && (friendsArray[i][j] > friendsArray[j][i])) {
                    predictionGift[i]++;
                }
                if (i != j && (friendsArray[i][j] < friendsArray[j][i])) {
                    predictionGift[j]++;
                }
                if (i != j && (friendsArray[i][j] == friendsArray[j][i])) {
                    if (indexGift[i] > indexGift[j]) {
                        predictionGift[i]++;
                    }
                    if (indexGift[i] < indexGift[j]) {
                        predictionGift[j]++;
                    }
                }
            }
        }

        Arrays.sort(predictionGift);
        answer = predictionGift[friends.length - 1] / 2;

        System.out.println(answer);
    }
}
