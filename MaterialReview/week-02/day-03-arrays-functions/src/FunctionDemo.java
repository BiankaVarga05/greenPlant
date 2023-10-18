import java.util.Arrays;

public class FunctionDemo {
    public static void main(String[] args) {
        // *** hello world ****

        helloWorld();

        // *** greet ***

        String name = "Geza";
        // the below function calls all look the same from the greet function
        greet(name);
        greet("Ge" + "za");
        greet("Geza");

        // *** create greeting ***

        // return a value and store in a variable
        String greeting = createGreeting(name, 1);
        System.out.println(greeting);

        // return a value and immediately use it
        System.out.println(createGreeting("Geza", 2));

        // *** increment a number ***

        int number = 5;
        // number is passed by value
        int incrementedNumber = incrementNumber(number);
        System.out.println(number); // 5
        System.out.println(incrementedNumber); // 6

        // *** increment numbers in array ***

        int[] numbers = {1, 2, 3};
        // numbers is passed by reference
        int[] incrementedNumbers = incrementNumbers(numbers);
        System.out.println(Arrays.toString(numbers)); // 2, 3, 4
        System.out.println(Arrays.toString(incrementedNumbers)); // 2, 3, 4
    }

    public static void helloWorld() {
        String greeting = "Hello World";
        System.out.println(greeting);
    }

    public static void greet(String name) {
        String greeting = "Hello " + name;
        System.out.println(greeting);
    }

    public static String createGreeting(String name, int number) {
        String greeting = "Hello " + name + " " + String.valueOf(number);
        return greeting;
    }

    public static int incrementNumber(int number) {
        System.out.println(number); // printing is side effect
        number++; // only changes the local number variable
        return number;
    }

    public static int[] incrementNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]++; // changes the original array
        }

        return numbers;
    }
}
