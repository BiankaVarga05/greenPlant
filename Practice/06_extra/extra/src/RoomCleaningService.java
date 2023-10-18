
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Create a RoomCleaningService class that
// will initialize streets present in the given district.
public class RoomCleaningService {

  private List<Street> streetsInDistrict;

  public RoomCleaningService() {
    streetsInDistrict = new ArrayList<>();
    initializeDistrict();
  }

  private void initializeDistrict() {
    Street firstStreet = new Street("Aradi", false);
    Street secondStreet = new Street("Kisfaludy", false);
    Street thirdStreet = new Street("Thököly", true);

    House firstHouse = new House("Kovácsék", true);
    firstHouse.addRoom(new Room("Nappali"));
    firstHouse.addRoom(new Room("Dolgozó"));

    House secondHouse = new House("Szabóék", true);
    secondHouse.addRoom(new Room("Nappai"));
    secondHouse.addRoom(new Room("Háló"));

    House fourthHouse = new House("Benedekék", true);
    fourthHouse.addRoom(new Room("Gyerekszoba"));
    fourthHouse.addRoom(new Room("Nappali"));
    fourthHouse.addRoom(new Room("Vendégszoba"));

    House fifthHouse = new House("Ravaszék", false);
    fifthHouse.addRoom(new Room("Büntetőszoba"));

    firstStreet.addHouse(firstHouse);
    firstStreet.addHouse(secondHouse);

    secondStreet.addHouse(fourthHouse);

    thirdStreet.addHouse(fifthHouse);

    streetsInDistrict.add(firstStreet);
    streetsInDistrict.add(secondStreet);
    streetsInDistrict.add(thirdStreet);
  }

  public void reportStatus(String message) {
    System.out.println();
    System.out.println("<<< " + message.toUpperCase() + " >>>");

    for (Street street : streetsInDistrict) {
      for (House house : street.getHouses()) {
        System.out.println("Status of " + house.getOwner() + " ----------");
        for (Room room : house.getRooms()) {
          System.out.println(room);
        }
      }
    }
  }

  // You can do cleaning only in those streets that are
  // not closed and in houses that have cleaning permission.

  // Tasks need to be done:
  // Clean shelves if they are dirty.
  // Sort books if they are not sorted.
  // Clean carpet if it is not clean.
  // Tidy tables if they are not tidy.
  // Clean windows if they are not clean.
  // Fresh air if that is not fresh.

  // As a representation of the cleaning process, simply set the relevant attributes to true.
  // For example: cleaning shelves means setting the shelvesAreClean attribute to true.

  // Write a clean() function that is able to do the necessary cleaning task based on a given
  // parameter(s?)

  // Possible implementation of cleaning the shelves:
  public void clean(boolean cleanShelves) {
    for (Street street : streetsInDistrict) {
      if (!street.isClosed()){
        for (House house : street.getHouses()) {
          if (house.hasPermission()){
            for (Room room : house.getRooms()) {
              if (cleanShelves){
                //if (!room.areShelvesClean()){
                  room.cleanShelves();
                  // room.cleanCarpet();
                //}
              }
            }
          }
        }
      }
    }
  }








  public void cleanBetter(Predicate<Room> condition, Cleanable cleanable) {
    for (Street street : streetsInDistrict) {
      if (!street.isClosed()){
        for (House house : street.getHouses()) {
          if (house.hasPermission()){
            for (Room room : house.getRooms()) {
                if (!condition.test(room)) {
                  cleanable.clean(room);
                }
            }
          }
        }
      }
    }
  }
}
