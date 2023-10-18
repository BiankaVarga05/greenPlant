// https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        String lowerCaseString = text.toLowerCase();
        String[] chars = lowerCaseString.split("");
        Map<String, Integer> counters = new HashMap<>();

        for (String ch : chars) {
            if (counters.containsKey(ch)) {
                Integer currentCount = counters.get(ch);
                counters.put(ch, currentCount + 1);
            } else {
                counters.put(ch, 1);
            }
        }

        int countOfMultiChars = 0;
        for (String ch : counters.keySet()) {
            Integer count = counters.get(ch);
            if (count > 1) {
                countOfMultiChars++;
            }
        }

        return countOfMultiChars;
    }

    public static void main(String[] args) {
        System.out.println(duplicateCount("aabBcde"));
    }
}