// https://www.codewars.com/kata/54b42f9314d9229fd6000d9c

public class DuplicateEncoder {
    public static boolean isSingleLetter(char ch, String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static String duplicateEncode(String word) {
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            char ch = word.toLowerCase().charAt(i);
            if (isSingleLetter(ch, word)) {
                result += "(";
            } else {
                result += ")";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(duplicateEncode("din")); // (((
        System.out.println(duplicateEncode("Success")); // )())())
    }
}
