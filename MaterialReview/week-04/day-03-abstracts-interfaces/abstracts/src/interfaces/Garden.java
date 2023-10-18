package interfaces;

import java.util.ArrayList;
import java.util.List;

// For the business logic create a Garden class
// which contains all the things that need to be watered
// and manages watering activities.
// In must have the possibility to add items to be watered.
// It must have a water() and a getStatus() method.
public class Garden {
  List<Waterable> waterables = new ArrayList<>();

  public void add(Waterable waterableThing){
    waterables.add(waterableThing);
  }

  public void water(int amount){
    for (Waterable waterable : waterables) {
      waterable.water(amount);
    }
  }
}

