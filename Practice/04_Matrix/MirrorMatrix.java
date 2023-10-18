public class MirrorMatrix {

    public static int[][] mirrorMatrix(int[][] input){
        int row = input.length;
        int col = input[0].length;
        int[][] mirrored = new int[row][col];

        for (int i = 0; i < row; i++){
            for (int j = col - 1; j >= 0; j--){
                mirrored[i][j] = input[i][col - j - 1];
            }
        }
        return mirrored;
    }

    public static void main(String[] args) {
        int[][] original = {
                {1,2,3,4},
                {5,6,7,8}
        };
        int[][] result = mirrorMatrix(original);
    }
}
