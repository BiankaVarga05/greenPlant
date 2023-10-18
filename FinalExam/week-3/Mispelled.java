// https://www.codewars.com/kata/5892595f190ca40ad0000095

public class Mispelled {
    public static boolean mispelled(String word1, String word2) {
        if (Math.abs(word1.length() - word2.length()) == 1 &&
                (word1.contains(word2) || word2.contains(word1))) {
           return true;
        }
        if (word1.length() == word2.length()) {
            int diffs = 0;
            for (int i = 0; i < word1.length(); i++) {
               if (word1.charAt(i) != word2.charAt(i)) {
                   diffs++;
               }
            }
            return diffs == 1;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(mispelled("versed", "xersed"));
        System.out.println(mispelled("1versed", "versed"));
        System.out.println(mispelled("versed", "applb"));
    }
}
