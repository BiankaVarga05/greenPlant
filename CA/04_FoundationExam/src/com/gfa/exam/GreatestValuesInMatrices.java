package com.gfa.exam;

public class GreatestValuesInMatrices {
    public static int[][] mergeMatrix(int[][] matrix1, int[][] matrix2) {
        // 1. invalid input
        if (matrix1 == null || matrix2 == null) {
            throw new IllegalArgumentException();
        }

        // 2. not the same size
        if (matrix1.length != matrix2.length) {
            throw new IllegalArgumentException();
        }

        int[][] results = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            // 3. non-square matrix
            if (matrix1.length != matrix1[i].length) {
                throw new IllegalArgumentException();
            }
            if (matrix2.length != matrix2[i].length) {
                throw new IllegalArgumentException();
            }

            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] > matrix2[i][j]) {
                    results[i][j] = matrix1[i][j];
                } else {
                    results[i][j] = matrix2[i][j];
                }
            }
        }

        return results;
    }
}
