package interfaces;

public abstract class Plant implements Waterable {
  double height;
  String color;

  public Plant(int height, String color) {
    this.height = height;
    this.color = color;
  }

  public abstract void water(int waterAmount);

  public void printStatus(){
    System.out.println("My color is " + color + " and my height is " + height);
  }
}
