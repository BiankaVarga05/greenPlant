import java.security.spec.InvalidParameterSpecException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static int divide() throws ArithmeticException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int result = num1 / num2;
        return result;
    }

    public static void ensureAge(int age) throws InvalidParameterSpecException {
        if (age < 18) {
            throw new InvalidParameterSpecException("You're too young to enter");
        }
    }

    public static void enterPage1(int age) throws InvalidParameterSpecException {
        ensureAge(age);
    }

    public static boolean enterPage2(int age) {
        try {
            ensureAge(age);
            return true;
        } catch (InvalidParameterSpecException e) {
            System.out.println(e);
            return false;
        } finally {
            // Finally block will always run despite the `return`
            System.out.println("Login completed");
        }
    }

    public static void main(String[] args) throws Exception {
        // Compile-time error
        boolean isItMonday = "yes";

        // Runtime error = exception
        System.out.println(1 / 0);

        // Throwing an exception
        throw new Exception("Something is terribly wrong");

        // Catching an exception
        try {
            enterPage(20);
        } catch (InvalidParameterSpecException e) {
            System.out.println(e);
            System.exit(1);
        }
        System.out.println("You're ready to buy beer");

        // Catching multiple exceptions
        try {
            System.out.println(divide());
        } catch (ArithmeticException e) {
            System.out.println("Sorry, we can't divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");
        }

        // Catching multiple exceptions at once
        try {
            System.out.println(divide());
        } catch (ArithmeticException | InputMismatchException e) {
            System.out.println("Invalid input");
        }

        // Catching all exceptions
        // DON'T DO THIS!
        try {
            System.out.println(divide());
        } catch (Exception e) {
            // `Exception` with catch every exception type
            // including ArithmeticException and InputMismatchException
            System.out.println("Invalid input");
        }
    }
}
