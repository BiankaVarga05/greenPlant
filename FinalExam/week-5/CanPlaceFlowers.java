// https://leetcode.com/problems/can-place-flowers/

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i == flowerbed.length - 2 && flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i > 1 && i < flowerbed.length - 2 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if (n == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1)); // true
        System.out.println(canPlaceFlowers(flowerbed, 2)); // false
    }
}
