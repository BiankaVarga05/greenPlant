import java.util.Arrays;
import java.util.List;

public class ListTraversal {
    public static void printNumbers(List<Integer> numbers) {
        System.out.println("numbers = " + numbers);

        // Base case
        if (numbers.isEmpty()) {
            System.out.println("Base case");
            return;
        }

        int first = numbers.get(0);
        System.out.println(first);

        // Recursive case
        List<Integer> rest = numbers.subList(1, numbers.size());
        printNumbers(rest);
    }

    public static boolean contains(List<Integer> numbers, Integer number) {
        System.out.println("numbers = " + numbers);

        // Base case 1: not found
        if (numbers.isEmpty()) {
            System.out.println("Base case / not found");
            return false;
        }

        // Base case 2: found
        int first = numbers.get(0);
        if (first == number) {
            System.out.println("Base case / found");
            return true;
        }

        // Recursive case
        List<Integer> rest = numbers.subList(1, numbers.size());
        boolean isFound = contains(rest, number);
        return isFound;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        printNumbers(numbers);

        System.out.println(contains(numbers, 4));
        System.out.println(contains(numbers, 9));
    }
}
