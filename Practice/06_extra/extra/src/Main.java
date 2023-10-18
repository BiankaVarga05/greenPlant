public class Main {

  // Create a Main class, initialize your RoomCleaningService and test your logic
  // by creating and calling a reportStatus() method. For this, override the toString()
  // method of the rooms and print everything you need so as to see the status of the room.
  public static void main(String[] args) {
    RoomCleaningService service = new RoomCleaningService();
    service.reportStatus("Initial status");

    // Clean Shelves
    // service.clean(true);
    // service.cleanBetter(new ShelfCleaner());
    //service.cleanBetter(new BookSorter());
    service.cleanBetter(room -> room.areBooksSorted(), room -> room.sortBooks());
    service.cleanBetter(room -> room.isCarpetClean(), room -> room.cleanCarpet());
    service.cleanBetter(room -> room.isAirFresh(), room -> room.cleanTable());


    // Sort books
    // Clean carpet
    // Tidy table
    // Clean windows
    // Fresh air
    service.reportStatus("After cleaning shelves");
  }
}
