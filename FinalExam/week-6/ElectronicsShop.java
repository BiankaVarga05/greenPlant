// https://www.hackerrank.com/challenges/electronics-shop/

import java.util.ArrayList;
import java.util.List;

public class ElectronicsShop {
    public static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                Integer sum = keyboards[i] + drives[j];
                if (sum <= budget) {
                    prices.add(sum);
                }
            }
        }

        Integer max = -1;
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) > max) {
                max = prices.get(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] keyboards1 = new int[]{40, 50, 60};
        int[] drives1 = new int[]{5, 8, 12};
        int budget1 = 60;
        System.out.println(getMoneySpent(keyboards1, drives1, budget1)); // 58

        int[] keyboards2 = new int[]{4};
        int[] drives2 = new int[]{5};
        int budget2 = 5;
        System.out.println(getMoneySpent(keyboards2, drives2, budget2)); // -1
    }
}
