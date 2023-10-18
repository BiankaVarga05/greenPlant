package interfaces;

public class Tulip extends Plant {

  public Tulip(int height, String color) {
    super(height, color);
  }

  public void water(int waterAmount){
    height += waterAmount * 0.09;
  }
}
