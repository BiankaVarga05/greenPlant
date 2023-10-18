// https://www.codewars.com/kata/54224ce3dda526a97d00127d

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCalculator {
    public static Integer evaluate(String[] arr) {
        List<String> subResult = new ArrayList<>(Arrays.asList(arr));

        try {
            while (subResult.contains("*")) {
                for (int i = 0; i < subResult.size(); i++) {
                    if (subResult.get(i) == "*") {
                        int operand1 = Integer.parseInt(subResult.get(i - 1));
                        int operand2 = Integer.parseInt(subResult.get(i + 1));
                        int result = operand1 * operand2;
                        subResult.remove(i + 1);
                        subResult.remove(i);
                        subResult.remove(i - 1);
                        subResult.add(i - 1, Integer.toString(result));
                        break;
                    }
                }
            }

            while (subResult.contains("+")) {
                for (int i = 0; i < subResult.size(); i++) {
                    if (subResult.get(i) == "+") {
                        int operand1 = Integer.parseInt(subResult.get(i - 1));
                        int operand2 = Integer.parseInt(subResult.get(i + 1));
                        int result = operand1 + operand2;
                        subResult.remove(i + 1);
                        subResult.remove(i);
                        subResult.remove(i - 1);
                        subResult.add(i - 1, Integer.toString(result));
                        break;
                    }
                }
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return -1;
        }

        if (subResult.size() > 1) {
            return -1;
        }

        return Integer.parseInt(subResult.get(0));
    }

    public static void main(String[] args) {
        System.out.println(evaluate(new String[]{"10", "+", "20", "*", "3"})); // 70
        System.out.println(evaluate(new String[]{"10", "+", "20", "*", "3", "*"})); // -1
        System.out.println(evaluate(new String[]{"10", "20", "*", "3"})); // -1
    }
}
