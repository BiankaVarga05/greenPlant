// https://www.hackerrank.com/challenges/strong-password

public class StrongPassword {
    /*
    Its length is at least 6
    It contains at least one digit.
    It contains at least one lowercase English character.
    It contains at least one uppercase English character.
    It contains at least one special character. The special characters are: !@#$%^&*()-+
     */
    public static int minimumNumber(String password) {
        int missingChars = 0;
        String specialChars = "!@#$%^&*()-+";

        boolean digitFound = false;
        boolean upperCaseFound = false;
        boolean lowerCaseFound = false;
        boolean specialFound = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                digitFound = true;
            } else if (Character.isUpperCase(ch)) {
                upperCaseFound = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFound = true;
            } else if (specialChars.contains(String.valueOf(ch))) {
                specialFound = true;
            }
        }

        if (!digitFound) {
            missingChars += 1;
        }
        if (!lowerCaseFound) {
            missingChars += 1;
        }
        if (!upperCaseFound) {
            missingChars += 1;
        }
        if (!specialFound) {
            missingChars += 1;
        }

        if (password.length() + missingChars < 6) {
            missingChars += 6 - (password.length() + missingChars);
        }

        return missingChars;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumber("2bbbb"));
        System.out.println(minimumNumber("2bb#A"));
    }
}
