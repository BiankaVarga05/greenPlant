// https://www.codewars.com/kata/58f6000bc0ec6451960000fd

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectiveArrayReversing {
    public static Integer[] selReverse(Integer[] array, int length) {
        Integer[] result = new Integer[array.length];

        for (int i = 0; i < array.length; i += length) {
            List<Integer> subArray = new ArrayList<>();
            for (int j = i; j < i + length; j++) {
                if (j < array.length) {
                    subArray.add(array[j]);
                }
            }
            Collections.reverse(subArray);

            for (int j = 0; j < subArray.size(); j++) {
                result[i + j] = subArray.get(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selReverse(new Integer[]{1, 2, 3, 4, 5, 6}, 2)));
        System.out.println(Arrays.toString(selReverse(new Integer[]{2, 4, 6, 8, 10, 12, 14, 16}, 3)));
    }
}
