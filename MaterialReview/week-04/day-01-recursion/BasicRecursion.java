public class BasicRecursion {
    public static void helloWorld(int count) {
        System.out.println("count = " + count);
        System.out.println("Hello World!");

        // Base case
        if (count == 5) {
            System.out.println("Base case");
            return;
        }

        // Recursive case
        System.out.println("Recursive case");
        helloWorld(count + 1);
    }

    public static void printNumbers(int n, int limit) {
        System.out.println("n = " + n);
        System.out.println(n);

        // Base case
        if (n == limit) {
            System.out.println("Base case");
            return;
        }

        // Recursive case
        printNumbers(n + 1, limit);
    }

    public static int factorial(int n) {
        System.out.println("n = " + n);

        // Base case
        if (n == 0 || n == 1) {
            System.out.println("Base case");
            return 1;
        }

        // Recursive case
        int result = n * factorial(n - 1);
        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) {
        helloWorld(1);

        printNumbers(1, 5);

        System.out.println(factorial(5));
    }
}
