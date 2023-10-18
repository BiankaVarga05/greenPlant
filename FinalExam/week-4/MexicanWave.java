// https://www.codewars.com/kata/58f5c63f1e26ecda7e000029

import java.util.ArrayList;
import java.util.List;

public class MexicanWave {
    public static String capitalize(String str, int i) {
        String result = "";

        for (int j = 0; j < str.length(); j++) {
            if (i == j) {
                result += String.valueOf(str.charAt(j)).toUpperCase();
            } else {
                result += str.charAt(j);
            }
        }

        return result;
    }

    public static List<String> wave(String str) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                result.add(capitalize(str, i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(wave("hel lo"));
    }
}
