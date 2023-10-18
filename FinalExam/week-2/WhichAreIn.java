// https://www.codewars.com/kata/550554fd08b86f84fe000a58

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        List<String> results = new ArrayList<>();

        for (String word1 : array1) {
            for (String word2 : array2) {
                if (word2.contains(word1)) {
                    results.add(word1);
                    break;
                }
            }
        }

        String[] resultArr = results.toArray(new String[results.size()]);
        Arrays.sort(resultArr);
        return resultArr;
    }

    public static void main(String[] args) {
        String[] a1 = new String[]{"arp", "live", "strong"};
        String[] a2 = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        System.out.println(Arrays.toString(inArray(a1, a2)));
    }
}
