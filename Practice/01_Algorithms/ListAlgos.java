import java.util.*;

public class ListAlgos {
    // Find out if there is any element that satisfies some condition
    public static boolean hasOdd(int[] numbers) {
        boolean foundOdd = false;

        for (int number : numbers) {
            if (number % 2 == 1) {
                foundOdd = true;
                break;
            }
        }

        return foundOdd;
    }

    // Find all elements that satisfy some condition
    public static List<Integer> filterOdd(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 1) {
                result.add(number);
            }
        }

        return result;
    }

    // Count elements that satisfy some condition
    public static int countOdd(int[] numbers) {
        int count = 0;

        for (int number : numbers) {
            if (number % 2 == 1) {
                count++;
            }
        }

        return count;
    }

    // Find the unique elements
    public static List<Integer> deduplicate(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            // !result.contains() is the same as result.contains() == false
            if (!result.contains(number)) {
                result.add(number);
            }
        }

        return result;
    }

    // Find the largest value
    public static int max(int[] numbers) throws ArrayIndexOutOfBoundsException {
        if (numbers.length == 0) {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }

        // assume that the 1st element is the largest
        int largest = numbers[0];

        // go through the remaining elements
        for (int i = 1; i < numbers.length; i++) {
            // if a larger element is found, make it the largest
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        return largest;
    }

    // Find the smallest value
    public static int min(int[] numbers) throws ArrayIndexOutOfBoundsException {
        if (numbers.length == 0) {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }

        // assume that the 1st element is the smallest
        int smallest = numbers[0];

        // go through the remaining elements
        for (int i = 1; i < numbers.length; i++) {
            // if a smaller element is found, make it the smallest
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }

        return smallest;
    }

    // Count the occurrences of each element
    public static Map<Integer, Integer> frequencies(int[] numbers) {
        // 'counters' will store a counter for each element of 'numbers'
        Map<Integer, Integer> counters = new HashMap<>();

        for (int number : numbers) {
            // if the counter for 'number' doesn't exist, create it
            if (!counters.containsKey(number)) {
                counters.put(number, 0);
            }
            // take the current value of the counter and increment it by 1
            counters.put(number, counters.get(number) + 1);
        }

        return counters;
    }

    // Find the number with the highest occurrence
    public static int maxFrequency(int[] numbers) throws ArrayIndexOutOfBoundsException {
        if (numbers.length == 0) {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }

        Map<Integer, Integer> counters = frequencies(numbers);

        int largestValue = -1; // -1 is smaller than any possible value
        int largestKey = -1; // the initial key can be anything

        for(Integer key : counters.keySet()) {
            if (counters.get(key) > largestValue) {
                largestValue = counters.get(key);
                largestKey = key;
            }
        }

        return largestKey;
    }

    public static void main(String[] args) {
        int[] numbers1 = { 8, 2, 3, 2, 7, 8, 3, 5, 1, 8 };
        int[] numbers2 = {};

        System.out.println("hasOdd:");
        System.out.println(hasOdd(numbers1));
        System.out.println(hasOdd(numbers2));

        System.out.println("filterOdd:");
        System.out.println(filterOdd(numbers1));
        System.out.println(filterOdd(numbers2));

        System.out.println("countOdd:");
        System.out.println(countOdd(numbers1));
        System.out.println(countOdd(numbers2));

        System.out.println("deduplicate:");
        System.out.println(deduplicate(numbers1));
        System.out.println(deduplicate(numbers2));

        System.out.println("max:");
        System.out.println(max(numbers1));
        try {
            System.out.println(max(numbers2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("empty");
        }

        System.out.println("min:");
        System.out.println(min(numbers1));
        try {
            System.out.println(min(numbers2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("empty");
        }

        System.out.println("frequencies:");
        System.out.println(frequencies(numbers1));
        System.out.println(frequencies(numbers2));

        System.out.println("maxFrequency:");
        System.out.println(maxFrequency(numbers1));
        try {
            System.out.println(maxFrequency(numbers2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("empty");
        }
    }
}
