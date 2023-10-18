// https://www.codewars.com/kata/57ea5b0b75ae11d1e800006c

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByStringLength {
    public static String findShortestWord(List<String> words) {
        String shortest = words.get(0);

        for (int i = 1; i < words.size(); i++) {
            if (words.get(i).length() < shortest.length()) {
                shortest = words.get(i);
            }
        }

        return shortest;
    }

    public static String[] sortByLength(String[] array) {
        List<String> words = new ArrayList<>(Arrays.asList(array));
        List<String> sortedWords = new ArrayList<>();

        while (!words.isEmpty()) {
            String shortest = findShortestWord(words);
            sortedWords.add(shortest);
            words.remove(shortest);
        }

        return sortedWords.toArray(new String[sortedWords.size()]);
    }

    public static void main(String[] args) {
        String[] words = new String[]{ "Telescopes", "Glasses", "Eyes", "Monocles" };
        System.out.println(Arrays.toString(sortByLength(words)));
    }
}
