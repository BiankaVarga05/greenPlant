package foodshop;

public class Dairy extends ShopItem {
    public Dairy(String name, int price, int preservativePercentage){
        super(name, price, preservativePercentage);
    }

    @Override
    public int calculateFreshness(){
        if(daysInTheShop > 5){
            return 0;
        } else if(daysInTheShop > 3 && daysInTheShop <= 5){
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
            int newPrice = price * 50 / 100;
//            if(newPrice < 0){
//                price = 0;
//            } else {
//                price = newPrice;
//            }
            //      feltétel     ? ha igaz : ha hamis
            price = newPrice < 0 ? 0 : newPrice;
            System.out.println("Reduced price (-50%): " + price);
        } else if(freshness == 1){
            int newPrice = price * 70 / 100;
            price = newPrice < 0 ? 0 : newPrice;
            System.out.println("Reduced price (-30%): " + price);
        } else {
            System.out.println("The price has not been reduced yet!");
        }
    }
}