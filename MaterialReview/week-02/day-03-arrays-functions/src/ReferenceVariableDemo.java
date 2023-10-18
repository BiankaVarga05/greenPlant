import java.util.Arrays;

public class ReferenceVariableDemo {
    public static void main(String[] args) {
        // null
        String name = null; // empty (doesn't refer to any memory location)

        // copying a number
        int number = 1;
        int numberCopy = number;
        number = 2;
        System.out.println(number); // 1
        System.out.println(numberCopy); // 2

        // copying an array = copying the reference to the array
        int[] numbers1 = { 1, 2, 3 };
        int[] numbersCopy1 = numbers1.clone();
        numbers1[0] = 5;
        System.out.println(Arrays.toString(numbers1)); // { 5, 2, 3 }
        System.out.println(Arrays.toString(numbersCopy1)); // { 5, 2, 3 }

        // cloning an array
        int[] numbers2 = { 1, 2, 3 };
        int[] numbersCopy2 = numbers2.clone();
        numbers2[0] = 5;
        System.out.println(Arrays.toString(numbers2)); // { 5, 2, 3 }
        System.out.println(Arrays.toString(numbersCopy2)); // { 1, 2, 3 }

        // comparing arrays
        int[] numbers3 = { 1, 2, 3 };
        int[] numbersCopy3 = numbers3.clone();
        System.out.println(numbers3 == numbersCopy3); // false
        System.out.println(Arrays.equals(numbers3, numbersCopy3)); // true

        // comparing strings
        String numbersAsString = Arrays.toString(numbers3);
        String numbersCopyAsString = Arrays.toString(numbersCopy3);
        System.out.println(numbersAsString == numbersCopyAsString); // false
        System.out.println(numbersAsString.equals(numbersCopyAsString)); // true

        // in this case the JVM recognises that the 2 strings are the same but
        // you cannot rely on it
        String name1 = "Leo";
        String name2 = "Leo";
        System.out.println(name1 == name2); // true
    }
}
