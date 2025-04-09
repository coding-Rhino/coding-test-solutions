package src.Lv2.Clothes;

import java.util.*;

public class Clothes {
    public static void main(String[] args) {
        String[][][] testCases = {
                {
                        {"yellow_hat", "headgear"},
                        {"blue_sunglasses", "eyewear"},
                        {"green_turban", "headgear"}
                },
                {
                        {"crow_mask", "face"},
                        {"blue_sunglasses", "face"},
                        {"smoky_makeup", "face"}
                }
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solution(testCases[i]);
            System.out.println(result);
        }
    }
    public static int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] item : clothes) {
            String type = item[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        int result = 1;
        for (int count : clothesMap.values()) {
            result *= (count + 1);
        }

        return result - 1;
    }
}
