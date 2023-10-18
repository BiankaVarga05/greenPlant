// https://www.codewars.com/kata/559cc2d2b802a5c94700000c

import java.util.Arrays;

public class ConsecutiveNumbers {
    public static int consecutive(final int[] arr) {
        int[] arrayCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrayCopy);
        return arrayCopy[arrayCopy.length - 1] - arrayCopy[0] - (arrayCopy.length - 2) - 1;
    }

    public static void main(String[] args) {
        System.out.println(consecutive(new int[]{4, 8, 6}));
        System.out.println(consecutive(new int[]{3, 4, 7, 10}));
    }
}
