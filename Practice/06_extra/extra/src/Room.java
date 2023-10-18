// Every room has a name (like: bathroom, living room, bedroom, child’s room, etc.
// - must be given at creation)
// and the following attributes:

// Shelves may be clean or not
// Books may be sorted or not;
// Carpet may be clean or not;
// Tables might be tidy or not;
// Windows might be dirty or not;
// Air might be fresh or not;
// The door of the room might be open or not
public class Room {
  private String name;
  private boolean shelvesAreClean;
  private boolean booksAreSorted;
  private boolean carpetIsClean;
  private boolean tableIsTidy;
  private boolean windowIsClean;
  private boolean airIsFresh;
  private boolean doorIsOpen;

  public Room (String name){
    this.name = name;
  }

  //region Cleaning methods
  public void cleanShelves() {
    shelvesAreClean = true;
  }

  public void sortBooks() {
    booksAreSorted = true;
  }

  public void cleanCarpet() {
    carpetIsClean = true;
  }

  public void cleanTable() {
    tableIsTidy = true;
  }

  public void cleanWindows() {
    windowIsClean = true;
  }

  public void refreshAir() {
    airIsFresh = true;
  }
  //endregion

  //region Getters
  public boolean areShelvesClean() {
    return shelvesAreClean;
  }

  public boolean areBooksSorted() {
    return booksAreSorted;
  }

  public boolean isCarpetClean() {
    return carpetIsClean;
  }

  public boolean isTableTidy() {
    return tableIsTidy;
  }

  public boolean areWindowsClean() {
    return windowIsClean;
  }

  public boolean isAirFresh() {
    return airIsFresh;
  }

  public boolean isDoorOpen() {
    return doorIsOpen;
  }

  //endregion

  @Override
  public String toString(){
    String happy = ":-)";
    String unhappy = "#messy#";
    String shelfStatus =  "  Shelves: " + (shelvesAreClean ?  happy : unhappy) +'\n';
    String bookStatus = "  Books: " + (booksAreSorted ?  happy : unhappy) +'\n';
    String carpetStatus = "  Carpet: " + (carpetIsClean ?  happy : unhappy) +'\n';
    String tableStatus = "  Table: " + (tableIsTidy ? happy : unhappy) +'\n';
    String windowStatus = "  Window: " + (windowIsClean ? happy : unhappy) +'\n';
    String airStatus = "  Air: " + (airIsFresh ? happy : unhappy) +'\n';

    return name + " looks: \n" + shelfStatus + bookStatus + carpetStatus + tableStatus + windowStatus + airStatus;
  }
}
