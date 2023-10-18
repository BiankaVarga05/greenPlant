package com.gfa.exam;

import static org.junit.jupiter.api.Assertions.*;

class GreatestValuesInMatricesTest {

    @org.junit.jupiter.api.Test
    void mergeMatrixMerges2x2matrices() {
        // Arrange
        int[][] matrix1 = {
                {2, 1},
                {0, 1}
        };
        int[][] matrix2 = {
                {0, 3},
                {-1, 1}
        };
        int[][] expected = {
                {2, 3},
                {0, 1}
        };

        // Act
        int[][] actual = GreatestValuesInMatrices.mergeMatrix(matrix1, matrix2);

        // Assert
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void mergeMatrixMerges3x3matrices() {
    }
}