import java.util.*;

public class SymmetricMatrix {
    public static boolean isSymmetric(int[][] matrix) {
        if (matrix == null) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                return false;
            }

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
