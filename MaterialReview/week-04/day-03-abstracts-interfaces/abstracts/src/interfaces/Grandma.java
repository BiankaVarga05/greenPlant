package interfaces;

public class Grandma implements Waterable {
  boolean happy;

  @Override
  public void water(int waterAmount) {
    if (waterAmount > 0) {
      happy = true;
    }
  }

  public void cook(){
    //Grandma cooking here
  }
}
