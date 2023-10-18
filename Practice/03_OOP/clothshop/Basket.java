import java.util.ArrayList;

public class Basket {
    // Create a Basket class. A Basket has a capacity and a list of the Items which are in the Basket.
    // It has a constructor, which sets capacity. The item list is empty at the beginning.
    // A Basket can print out all of its Items.
    // A Basket has an addToBasket() method, which takes an Item as a param and puts it in the list and returns true, when it has capacity for it. If not, prints out that "Basket is full" and returns false.
    // A Basket has a buyAll() method, which calls the buy() method of every Item in the Basket and removes everything from the Basket.

    private int capacity;
    private ArrayList<Item> items;

    public Basket(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void printBasketItems(){
        for (Item item : items){
            item.printItem();
        }
    }

    public boolean addToBasket(Item newItem){
        if (items.size() < capacity){
            items.add(newItem);
            return true;
        } else {
            System.out.println("Basket is full");
            return false;
        }
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void setCapacity(int newCapacity){
        if(newCapacity >= 1){
            this.capacity = newCapacity;
        }
    }

    public void buyAll(){
        for (Item item : items){
            item.buy();
        }
        items.clear();
    }
}
