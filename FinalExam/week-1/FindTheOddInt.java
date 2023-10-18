// https://www.codewars.com/kata/54da5a58ea159efa38000836

public class FindTheOddInt {
    public static int findIt(int[] a) {
        for (int numToCount : a) {
            int count = 0;
            for (int num : a) {
                if (numToCount == num) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                return numToCount;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findIt(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));
    }
}