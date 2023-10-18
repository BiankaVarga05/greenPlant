// https://www.codewars.com/kata/59f08f89a5e129c543000069

import java.util.Arrays;

public class StringArrayDuplicates {
    public static String dedupeWord(String word) {
        String result = "";
        String[] chars = word.split("");

        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 || !chars[i].equals(chars[i + 1])) {
                result += chars[i];
            }
        }

        return result;
    }

    public static String[] dup(String[] arr) {
        String[] results = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            results[i] = dedupeWord(arr[i]);
        }

        return results;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"abracadabra", "allottee", "assessee"};
        System.out.println(Arrays.toString(dup(input)));
    }
}