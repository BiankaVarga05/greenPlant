import java.util.*;

public class SudokuValidator {
    public static boolean isListValid(List<Integer> numbers) {
        if (numbers.size() != 9) {
            return false;
        }

        for (int i = 1; i <= 9; i++) {
            if (!numbers.contains(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isListValid2(List<Integer> numbers) {
        List<Integer> referenceList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            referenceList.add(i);
        }

        // Arrays.sort -> tömb rendezése
        // Collections.sort -> lista rendezése
        Collections.sort(numbers);

        return referenceList.equals(numbers);
    }

    public static boolean isSolutionValid(Integer[][] matrix) {
        // 1. sorok
        for (int row = 0; row < matrix.length; row++) {
            Integer[] numbersOfRow = matrix[row];
            List<Integer> numbersOfRowAsList = Arrays.asList(numbersOfRow);
            boolean isRowValid = isListValid(numbersOfRowAsList);
            if (!isRowValid) {
                return false;
            }
        }

        // matrix.length - sorok száma
        // matrix[0].length - oszlopok száma

        // 2. oszlopok
        for (int col = 0; col < matrix[0].length; col++) {
            List<Integer> numbersOfCol = new ArrayList<>();

            for (int row = 0; row < matrix.length; row++) {
                // 1. index mindig a sor (a belső tömb indexe)
                // 2. index mindig az oszlop (az elem indexe a belső tömbben)
                Integer elem = matrix[row][col];
                numbersOfCol.add(elem);
            }

            boolean isColValid = isListValid(numbersOfCol);
            if (!isColValid) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(2, 3, 4, 1, 5, 6, 8, 9, 7);
        System.out.println(isListValid(numbers1));

        List<Integer> numbers2 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(isListValid(numbers2));

        List<Integer> numbers3 = Arrays.asList(2, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(isListValid(numbers3));

        Integer[][] validBoard = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9},
        };
        System.out.println(isSolutionValid(validBoard));

        Integer[][] invalidBoard = {
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 6, 3, 3, 4, 2, 5, 6, 5},
                {8, 5, 9, 7, 6, 1, 6, 2, 7},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 4, 1, 5, 3, 7, 2, 1, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 2, 3, 4, 8, 1, 6, 7, 9},
        };
        System.out.println(isSolutionValid(invalidBoard));
    }
}
