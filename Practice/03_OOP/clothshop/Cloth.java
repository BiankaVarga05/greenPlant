public class Cloth extends Item {
    private String size;

    public Cloth(String name, int price, String color, String size){
        super(name, price, color);
        this.size = size;
    }

    @Override
    public void printItem(){
        if(isItSold){
            System.out.println(name + " (" + color + " - " + size + "): " + price + " Ft - sold");
        } else {
            System.out.println(name + " (" + color + " - " + size + "): " + price + " Ft");
        }
    }

    @Override
    public int discount(){
        this.price = this.price * 70 / 100;
        return this.price;
    }
}
