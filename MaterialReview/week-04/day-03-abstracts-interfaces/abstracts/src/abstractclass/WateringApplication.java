package abstractclass;

public class WateringApplication {
  //region Task description
  // Create an application that helps the caretaker/gardener to
  // organize the watering related tasks for any organization.

  // The user shall be able to water all the things that need water
  // for example Rose, Tuplip, Orchid, etc ...
  // The application shall handle watering activities
  // and report watering results.

  // For the business logic create a Garden class
  // which contains all the things that need to be watered
  // and manages watering activities.
  // In must have the possibility to add items to be watered.
  // It must have a water() and a getStatus() method.
  //endregion
  public static void main(String[] args) {
    Garden garden = new Garden();
    garden.add(new Rose(10, "Red"));
    garden.add(new Tulip(12, "Yellow"));
    garden.add(new Orchid(15, "Pink"));
    garden.add(new Rose(11, "Red"));
    //garden.add(new Plant(100, "Purple"));

    garden.water(20);
  }
}
