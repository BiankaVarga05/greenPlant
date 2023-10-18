// https://www.codewars.com/kata/5832db03d5bafb7d96000107

public class LotteryMachine {
    public static String lottery(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch) && !result.contains(Character.toString(ch))) {
                result += ch;
            }
        }

        if (result.isEmpty()) {
            return "One more round!";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lottery("hPrBKWDH8yc6Lt5NQZWQ")); // 865
        System.out.println(lottery("ynMAisVpHEqpqHBqTrwH")); // One more run!
        System.out.println(lottery("555")); // 5
    }
}
