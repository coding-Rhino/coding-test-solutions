package src.Lv1.UnfinishedRunner;

import java.util.*;

public class UnfinishedRunner {
    public static void main(String[] args) {

        String[][] participants = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };

        String[][] completions = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };

        for (int i = 0; i < participants.length; i++) {
            String result = solution(participants[i], completions[i]);
            System.out.println(result);
        }
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        return null;
    }
}
