import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricMatrixTest {
    @Test
    void isSymmetricReturnsTrueForSymmetric3x3Matrix() {
        int[][] matrix = {
                { 1, 0, 1 },
                { 0, 2, 2 },
                { 1, 2, 5 },
        };
        assertTrue(SymmetricMatrix.isSymmetric(matrix));
    }

    @Test
    void isSymmetricReturnsFalseForAsymmetric3x3Matrix() {
        int[][] matrix = {
                { 7, 7, 7 },
                { 6, 5, 7 },
                { 1, 2, 1 },
        };
        assertFalse(SymmetricMatrix.isSymmetric(matrix));
    }

    @Test
    void isSymmetricReturnsFalseForNonSquareMatrix() {
        int[][] matrix = {{ 1, 2, 3 }};
        assertFalse(SymmetricMatrix.isSymmetric(matrix));
    }

    @Test
    void isSymmetricReturnsFalseForNullMatrix() {
        int[][] matrix = null;
        assertFalse(SymmetricMatrix.isSymmetric(matrix));
    }
}
