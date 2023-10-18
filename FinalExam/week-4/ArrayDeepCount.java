// https://www.codewars.com/kata/596f72bbe7cd7296d1000029

import java.util.ArrayList;
import java.util.List;

public class ArrayDeepCount {
    public static int deepCountRecursive(Object[] array) {
        int count = 0;

        for (Object elem : array) {
            count++;
            if (elem instanceof Object[]) {
                count += deepCountRecursive((Object[]) elem);
            }
        }

        return count;
    }

    public static int deepCountNonRecursive(Object[] array) {
        List<Object[]> arraysToCount = new ArrayList<>();
        arraysToCount.add(array);
        int count = 0;

        while (!arraysToCount.isEmpty()) {
            Object[] nextArray = arraysToCount.remove(0);

            for (Object elem : nextArray) {
                count++;
                if (elem instanceof Object[]) {
                    arraysToCount.add((Object[]) elem);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Object[] strArray = new Object[]{"x", "y", new Object[]{"z"}};
        System.out.println(deepCountRecursive(strArray));
        System.out.println(deepCountNonRecursive(strArray));

        Object[] intArray = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}}};
        System.out.println(deepCountRecursive(intArray));
        System.out.println(deepCountNonRecursive(intArray));

        Object[] emptyArray = new Object[]{};
        System.out.println(deepCountRecursive(emptyArray));
        System.out.println(deepCountNonRecursive(emptyArray));
    }
}
