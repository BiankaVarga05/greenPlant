package abstractclass;

public class Orchid extends Plant {
  double orchidSpecificConst = 0.7;

  public Orchid(int height, String color) {
    super(height, color);
  }

  @Override
  public void water(int waterAmount){
    height += waterAmount * 0.09 + waterAmount * orchidSpecificConst;
  }
}
