package foodshop;
public abstract class ShopItem {
    protected String name;
    protected int price;
    protected int preservativePercentage;
    protected int daysInTheShop = 0;

    public ShopItem(String name, int price){
        this.name = name;
        this.price = price;
        // this.daysInTheShop = 0;
    }

    public ShopItem(String name, int price, int preservativePercentage){
        this.name = name;
        this.price = price;
        this.preservativePercentage = preservativePercentage;
    }

    public abstract int calculateFreshness();
    public abstract void reducePrice();

    public String convertFreshnessToString(){
        int freshness = calculateFreshness();

        if(freshness == 0){
            return "bad";
        } else if(freshness == 1){
            return "ok";
        } else if(freshness == 2) {
            return "good";
        } else {
            throw new RuntimeException("Not valid freshness");
        }
    }

    public void incrementDaysInTheShop(){
        // ++daysInTheShop;
        daysInTheShop += 1;
    }
}