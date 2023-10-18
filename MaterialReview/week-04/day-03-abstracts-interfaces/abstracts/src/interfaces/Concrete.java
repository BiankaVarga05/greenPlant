package interfaces;

public class Concrete implements Waterable {
  double size = 300;
  double waterContent = 30.0;

  @Override
  public void water(int amount){
    waterContent += size / amount * 0.71;
  }
}
