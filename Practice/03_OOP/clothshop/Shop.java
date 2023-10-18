import java.util.ArrayList;

public class Shop {
    // 1. Create 3 instances of the Item class: a T-Shirt, a hat and a shoe.
    // 2. Add them in the basket (which has 3 as capacity) and print all out.
    // 3. Try to add a new item, a skirt.
    // 4. Buy everything from the basket, then print out every item to check whether they became sold.
    // 5. Try to add the previous skirt in the basket, then print out the current items in the basket.
    public static void main(String[] args) {
        // 1.
        /* Item tShirt = new Item("T-Shirt", 2800, "white");
        Item hat = new Item("Hat", 8000, "black");
        Item shoe = new Item("Shoe", 500, "purple");
//        tShirt.printItem();
//        tShirt.buy();
//        tShirt.printItem();
//        shoe.printItem();

        // 2.
        Basket basket = new Basket(3);
        basket.addToBasket(tShirt);
        basket.addToBasket(hat);
        basket.addToBasket(shoe);
        basket.printBasketItems();

        // 3.
        Item skirt = new Item("Skirt", 6000, "blue");
        basket.addToBasket(skirt);
        System.out.println();

        // 4.
        basket.buyAll();
        tShirt.printItem();
        hat.printItem();
        shoe.printItem();
        System.out.println();

        // 5.
        basket.addToBasket(skirt);
        basket.printBasketItems();
        System.out.println();

        // 6. - discount
        System.out.println(tShirt.getPrice());
        System.out.println(tShirt.discount());
        System.out.println(tShirt.getPrice()); */

        // 7.
        Basket basket = new Basket(3);
        Cloth jeans = new Cloth("Jeans", 8500, "black", "M");
        Item cheese = new Item("Cheese", 2000, "green");
        Item tv = new Item("TV", 250000, "black");
        jeans.printItem();
        cheese.printItem();
        tv.printItem();
        System.out.println();
        basket.addToBasket(jeans);
        basket.addToBasket(cheese);
        basket.addToBasket(tv);

        ArrayList<Item> itemsCurrentlyInBasket = basket.getItems();
        for (Item currentItem : itemsCurrentlyInBasket){
            if(currentItem instanceof Cloth){
                currentItem.buy();
            }
        }
        jeans.printItem();
        tv.printItem();
        cheese.printItem();

    }
}

