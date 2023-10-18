package interfaces;

public class Orchid extends Plant implements Reportable {
  double orchidSpecificConst = 0.7;

  public Orchid(int height, String color) {
    super(height, color);
  }

  public void water(int waterAmount){
    height += waterAmount * 0.09 + waterAmount * orchidSpecificConst;
  }

  @Override
  public String report(){
    return "";
  }
}
