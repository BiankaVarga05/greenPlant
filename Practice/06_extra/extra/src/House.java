import java.util.ArrayList;
import java.util.List;

// Every house has an owner (represented by its name),
// might have permission for cleaning or not,
// and a different number of rooms.
// The owner name and permission state must be given at creation.
public class House {

  private List<Room> rooms;
  private String owner;
  private boolean hasPermission;

  public House(String owner, boolean hasPermission){
    rooms = new ArrayList<>();
    this.owner = owner;
    this.hasPermission = hasPermission;
  }

  public String getOwner() {
    return owner;
  }

  public void addRoom(Room room){
    rooms.add(room);
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public boolean hasPermission() {
    return hasPermission;
  }
}
