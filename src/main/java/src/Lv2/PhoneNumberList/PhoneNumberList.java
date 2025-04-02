package src.Lv2.PhoneNumberList;

import java.util.*;

public class PhoneNumberList {
    public static void main(String[] args) {
        String[][] testCases = {
                {"119", "97674223", "1195524421"},
                {"123", "456", "789"},
                {"12", "123", "1235", "567", "88"}
        };

        for (int i = 0; i < testCases.length; i++) {
            boolean result = solution(testCases[i]);
            System.out.println(result);
        }
    }

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                return false;
            }
        }

        return true;
    }
}
