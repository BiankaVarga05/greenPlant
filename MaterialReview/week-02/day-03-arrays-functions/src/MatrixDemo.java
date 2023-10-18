import java.util.Arrays;

public class MatrixDemo {
    public static void main(String[] args) {
        // declaration with `new`
        int rows = 4;
        int cols = 3;
        int[][] matrix = new int[rows][cols];

        // initialisation with literal
        int[][] scores = {
            { 301, 301, 301 },
            { 285, 270, 262 },
            { 248, 221, 230 },
            { 12, 0, 7 },
        };

        // accessing an element
        System.out.println(scores[1][2]); // row and column

        // accessing all elements by row
        for (int row = 0; row < scores.length; row++) {
            for (int col = 0; col < scores[row].length; col++) {
                System.out.print(scores[row][col] + " ");
            }
            System.out.println();
        }

        // accessing all elements by column
        for (int col = scores[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < scores.length; row++) {
                System.out.print(scores[row][col] + " ");
            }
            System.out.println();
        }

        // who won the game?
        int[] lastRound = scores[scores.length - 1];
        int winnerIndex = -1;

        for (int i = 0; i < lastRound.length; i++) {
            if (lastRound[i] == 0) {
                winnerIndex = i;
                break;
            }
        }

        System.out.println(winnerIndex);
    }
}
