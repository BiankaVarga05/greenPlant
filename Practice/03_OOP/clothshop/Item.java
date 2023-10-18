public class Item {
    // Create an Item class. An Item has a name, a price, a color and an isItSold property.
    // It has a constructor, which sets name, price and color.
    // An Item can print out its properties in the following format: "<name> (<color>): <price> Ft" and "<name> (<color>): <price> Ft - sold" if its sold.
    // An Item is not sold by default, but it has a buy() method, which set isItSold true.
    // An item can be discounted by -20%. The discount() method returns the new price.

    protected String name;
    protected int price;
    protected String color;
    protected boolean isItSold = false;

    public Item(String name, int price, String color){
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public void printItem(){
        if(isItSold){
            System.out.println(name + " (" + color + "): " + price + " Ft - sold");
        } else {
            System.out.println(name + " (" + color + "): " + price + " Ft");
        }
    }

    public void buy(){
        isItSold = true;
    }

    public int discount(){
//        int discountedPrice = this.price * 80 / 100;
//        this.price = discountedPrice;
//        return discountedPrice;

        this.price = this.price * 80 / 100;
        return this.price;
    }

    public int getPrice() {
        return this.price;
    }
}
