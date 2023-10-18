// https://www.codewars.com/kata/526233aefd4764272800036f

import java.util.Arrays;

public class MatrixAddition {
    public static int[][] matrixAddition(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 1}
        };
        int[][] b = {
                {2, 2, 1},
                {3, 2, 3},
                {1, 1, 3}
        };
        System.out.println(Arrays.deepToString(matrixAddition(a, b)));
    }
}
