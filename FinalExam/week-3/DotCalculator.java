// https://www.codewars.com/kata/6071ef9cbe6ec400228d9531

public class DotCalculator {
    public static String calc(String txt){
        String[] parts = txt.split(" ");
        int num1 = parts[0].length();
        int num2 = parts[2].length();
        String operator = parts[1];

        int result;
        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("//")) {
            result = num1 / num2;
        } else {
            return "";
        }

        String resultDots = "";
        for (int i = 0; i < result; i++) {
            resultDots += ".";
        }
        return resultDots;
    }

    public static void main(String[] args) {
        System.out.println(calc("... + .."));
        System.out.println(calc("..... - ..."));
        System.out.println(calc("..... * .."));
        System.out.println(calc("..... // .."));
    }
}
