package abstractclass;

public class Tulip extends Plant {

  public Tulip(int height, String color) {
    super(height, color);
  }

  @Override
  public void water(int waterAmount){
    height += waterAmount * 0.09;
  }
}
