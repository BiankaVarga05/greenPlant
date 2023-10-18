package foodshop;

import java.util.ArrayList;

public class Shop {
    private ArrayList<ShopItem> stock;

    public Shop(){
        stock = new ArrayList<>();
    }

    public Shop(ArrayList<ShopItem> stock){
        this.stock = stock;
    }

    public ArrayList<ShopItem> getStock(){
        return stock;
    }

    public void fillStock(ShopItem newItem){
        stock.add(newItem);
    }

    public ArrayList<String> showStock(){
        ArrayList<String> itemInfoList = new ArrayList<>();
        for (int i = 0; i < stock.size(); i++) {
            ShopItem currentItem = stock.get(i);
            String currentInfo =
                    (i + 1) + ". item: " + currentItem.name
                            + ", " + currentItem.price + " Ft, "
                            + currentItem.convertFreshnessToString()
                            + " freshness";
            itemInfoList.add(currentInfo);
        }
        return itemInfoList;
    }

    public int getStockValue(){
        int sum = 0;
        for (ShopItem item : stock){
            sum += item.price;
        }
        return sum;
    }

    public void closeShop(){
        System.out.println("Checking and reducing every price...");
        for (ShopItem item : stock){
            item.incrementDaysInTheShop();
            System.out.println("--- " + item.name + " ---:");
            item.reducePrice();
        }
    }
}