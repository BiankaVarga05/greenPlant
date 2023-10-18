import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixAlgos {
    // Do some calculation with each element
    public static int[][] triple(int[][] matrix) {
        // 'output' has the same size as the input matrix
        int[][] outputMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                outputMatrix[row][col] = matrix[row][col] * 3;
            }
        }

        return outputMatrix;
    }

    // Transform the matrix
    public static List<Integer> flattenByRow(int[][] matrix) {
        List<Integer> flattenedList = new ArrayList<>();

        // Access each element of the matrix by row and add to the list
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                flattenedList.add(matrix[row][col]);
            }
        }

        return flattenedList;
    }

    public static List<Integer> flattenByColumn(int[][] matrix) {
        List<Integer> flattenedList = new ArrayList<>();

        // Access each element of the matrix by column and add to the list
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                flattenedList.add(matrix[row][col]);
            }
        }

        return flattenedList;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 11, 12 },
                { 21, 22 },
                { 31, 32 },
        };

        int[][] matrix2 = {
                { 11, 12, 13 },
                { 21, 22, 23 },
        };

        int[][] matrix3 = {{}};

        System.out.println("triple:");
        System.out.println(Arrays.deepToString(triple(matrix1)));
        System.out.println(Arrays.deepToString(triple(matrix2)));
        System.out.println(Arrays.deepToString(triple(matrix3)));

        System.out.println("flattenByRow:");
        System.out.println(flattenByRow(matrix1));
        System.out.println(flattenByRow(matrix2));
        System.out.println(flattenByRow(matrix3));

        System.out.println("flattenByColumn:");
        System.out.println(flattenByColumn(matrix1));
        System.out.println(flattenByColumn(matrix2));
        System.out.println(flattenByColumn(matrix3));
    }
}
