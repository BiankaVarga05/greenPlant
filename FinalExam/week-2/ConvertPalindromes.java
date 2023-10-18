// https://www.codewars.com/kata/5838a66eaed8c259df000003

import java.util.Arrays;

public class ConvertPalindromes {
    public static int isPalindrome(int number) {
        String[] digits = String.valueOf(number).split("");

        for (int i = 0; i < Math.floor(digits.length / 2); i++) {
           if (!digits[i].equals(digits[digits.length - 1 - i])) {
               return 0;
           }
        }

        return 1;
    }

    public static int[] convertPalindromes(int[] numbers) {
        int[] results = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            results[i] = isPalindrome(numbers[i]);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{ 101, 2, 85, 33, 14014 };
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(2));
        System.out.println(isPalindrome(23));
        System.out.println(Arrays.toString(convertPalindromes(numbers)));
    }
}
