// https://www.codewars.com/kata/55908aad6620c066bc00002a

public class ExesAndOhs {
    public static boolean getXO(String str) {
        int xCount = 0;
        int yCount = 0;
        String[] chars = str.split("");

        for (int i = 0; i < chars.length; i++) {
            if (chars[i].toLowerCase().equals("x")) {
                xCount++;
            } else if (chars[i].toLowerCase().equals("o")) {
                yCount++;
            }
        }

        return xCount == yCount;
    }

    public static void main(String[] args) {
        System.out.println(getXO("ooxXm"));
    }
}
