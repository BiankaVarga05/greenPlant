// https://www.codewars.com/kata/566044325f8fddc1c000002c

import java.util.ArrayList;
import java.util.List;

public class EvenCharacters {
    public static List<Character> evenChars(String str) {
        if (str.length() < 2 || str.length() > 100) {
            throw new IllegalArgumentException();
        }

        List<Character> result = new ArrayList<>();
        for (int i = 1; i < str.length(); i += 2) {
            result.add(str.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(evenChars("abcdefghijklm"));
    }
}
