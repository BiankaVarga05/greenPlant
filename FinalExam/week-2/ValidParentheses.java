// https://www.codewars.com/kata/52774a314c2333f0a7000688

public class ValidParentheses {
    public static boolean validParentheses(String parens) {
        int openCount = 0;
        int closeCount = 0;

        for (int i = 0; i < parens.length(); i++) {
            if (parens.charAt(i) == ')') {
                closeCount++;
                if (closeCount > openCount) {
                    return false;
                }
            } else if (parens.charAt(i) == '(') {
                openCount++;
            }
        }

        return openCount == closeCount;
    }

    public static void main(String[] args) {
        System.out.println(validParentheses(")(()))"));
        System.out.println(validParentheses("(())((()())())"));
    }
}
