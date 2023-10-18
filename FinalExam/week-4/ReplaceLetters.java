// https://www.codewars.com/kata/5a4331b18f27f2b31f000085

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceLetters {
    private static final Character[] alphabet = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final Character[] consonants = new Character[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static final Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};

    public static Character findNextVowel(char c) {
        List<Character> alphabetList = new ArrayList<>(Arrays.asList(alphabet));
        alphabetList.addAll(alphabetList);
        int index = alphabetList.indexOf(c);

        for (int i = index + 1; i < alphabetList.size(); i++) {
            Character currentChar = alphabetList.get(i);

            if (Arrays.asList(vowels).contains(currentChar)) {
                return currentChar;
            }
        }

        return null;
    }

    public static Character findPreviousConsonant(char c) {
        List<Character> alphabetList = new ArrayList<>(Arrays.asList(alphabet));
        alphabetList.addAll(alphabetList);
        int index = alphabetList.indexOf(c) + alphabet.length;

        for (int i = index - 1; i < alphabetList.size(); i--) {
            Character currentChar = alphabetList.get(i);

            if (Arrays.asList(consonants).contains(currentChar)) {
                return currentChar;
            }
        }

        return null;
    }

    public static String replaceLetters(String word) {
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);

            if (Arrays.asList(vowels).contains(currentChar)) {
                result += findPreviousConsonant(currentChar);
            } else {
                result += findNextVowel(currentChar);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(replaceLetters("cat")); // ezu
        System.out.println(replaceLetters("codewars")); // enedazuu
        System.out.println(replaceLetters("abcdtuvwxyz")); // zeeeutaaaaa
    }
}
