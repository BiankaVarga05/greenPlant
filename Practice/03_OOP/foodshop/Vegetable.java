package foodshop;

public class Vegetable extends ShopItem {
    public Vegetable(String name, int price){
        super(name, price);
        preservativePercentage = 0;
    }

    @Override
    public int calculateFreshness(){
        if(daysInTheShop > 3){
            return 0;
        } else if(daysInTheShop > 1 && daysInTheShop <= 3){
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public void reducePrice(){
        int freshness = calculateFreshness();

        System.out.println("Old price: " + price);
        if(freshness == 0){
            int newPrice = price * 60 / 100;
            //      feltétel     ? ha igaz : ha hamis
            price = newPrice < 0 ? 0 : newPrice;
            System.out.println("Reduced price (-40%): " + price);
        } else if(freshness == 1){
            int newPrice = price * 80 / 100;
            price = newPrice < 0 ? 0 : newPrice;
            System.out.println("Reduced price (-20%): " + price);
        } else {
            System.out.println("The price has not been reduced yet!");
        }
    }
}