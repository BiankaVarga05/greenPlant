package foodshop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ShopItem shopItem1 = new ShopItem("banana", 200);
//        ShopItem shopItem2 = new ShopItem("apple", 100, 10);

        Dairy milk = new Dairy("milk", 300, 20);
//        milk.incrementDaysInTheShop();
//        milk.incrementDaysInTheShop();
//        milk.incrementDaysInTheShop();
//        milk.incrementDaysInTheShop();
//        System.out.println(milk.daysInTheShop);
//        System.out.println(milk.calculateFreshness());
//        try {
//            System.out.println(milk.convertFreshnessToString());
//        } catch (Exception e){
//            System.out.println(e);
//        }

        Vegetable tomato = new Vegetable("tomato", 300);
        tomato.incrementDaysInTheShop();
        tomato.incrementDaysInTheShop();
        tomato.incrementDaysInTheShop();
        tomato.incrementDaysInTheShop();
        System.out.println(tomato.daysInTheShop);
        System.out.println(tomato.calculateFreshness());
        try {
            System.out.println(tomato.convertFreshnessToString());
        } catch (Exception e){
            System.out.println(e);
        }

        Shop shop1 = new Shop();
        System.out.println(shop1.getStock().isEmpty());

        ArrayList<ShopItem> items = new ArrayList<>();
        items.add(milk);
        items.add(tomato);
        Shop shop2 = new Shop(items);
        System.out.println(shop2.getStock().size());
        System.out.println(shop2.showStock());
        System.out.println(shop2.getStockValue());
        shop2.closeShop();
    }
}
