// https://www.hackerrank.com/challenges/gem-stones/problem

import java.util.Arrays;
import java.util.List;

public class GemStones {
    public static int gemstones(List<String> arr) {
        int numGemstones = 0;

        String[] chars = arr.get(0).split("");

        for (String ch : chars) {
            boolean isGemstone = true;

            for (int i = 1; i < arr.size(); i++) {
                if (!arr.get(i).contains(ch)) {
                    isGemstone = false;
                    break;
                }
            }

            if (isGemstone) {
                numGemstones++;
            }
        }

        return numGemstones;
    }

    public static void main(String[] args) {
        System.out.println(gemstones(Arrays.asList("abc", "abc", "bc")));
    }
}