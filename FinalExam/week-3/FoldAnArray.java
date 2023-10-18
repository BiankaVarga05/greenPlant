// https://www.codewars.com/kata/57ea70aa5500adfe8a000110

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoldAnArray {
    public static Integer[] foldOnce(final Integer[] array) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.floor(array.length / 2); i++) {
            result.add(array[i] + array[array.length - 1 -i]);
        }

        if (array.length % 2 == 1) {
            double middleElem = Math.ceil(array.length / 2);
            result.add(array[(int) middleElem]);
        }

        return result.toArray(new Integer[result.size()]);
    }

    public static Integer[] foldArray(final Integer[] array, int runs) {
        Integer[] result = array;
        for (int i = 0; i < runs; i++) {
            result = foldOnce(result);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(foldArray(arr, 1)));
        System.out.println(Arrays.toString(foldArray(arr, 2)));
    }
}
