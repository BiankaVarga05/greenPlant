// https://www.codewars.com/kata/6347f9715467f0001b434936

public class MatrixWeight {
    public static String thinOrFat(int[][] matrix) {
        double width = 0;
        double height = 0;

        for (int i = 0; i < matrix.length; i++) {
            double widthOfRow = 0;
            double heightOfColumn = 0;

            if (matrix.length == 0) {
                return null;
            }

            for (int j = 0; j < matrix[0].length; j++) {
                widthOfRow += matrix[i][j];
                heightOfColumn += matrix[j][i];
            }

            width += Math.sqrt(widthOfRow);
            height += Math.sqrt(heightOfColumn);
        }

        if (width < height) {
            return "thin";
        } else if (width > height) {
            return "fat";
        } else {
            return "perfect";
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 3} , {5, 7}};
        System.out.println(thinOrFat(matrix1));

        int[][] matrix2 = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        System.out.println(thinOrFat(matrix2));
    }
}
