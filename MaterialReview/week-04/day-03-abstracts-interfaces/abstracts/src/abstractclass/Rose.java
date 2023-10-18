package abstractclass;

public class Rose extends Plant {

  public Rose(int height, String color) {
    super(height, color);
  }

  @Override
  public void water(int waterAmount) {
    height += 0.02 * waterAmount;
  }
}
