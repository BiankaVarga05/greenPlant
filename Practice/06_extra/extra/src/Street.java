
import java.util.ArrayList;
import java.util.List;

// Every street has a name and can be closed or not closed.
// Both must be given at creation.
public class Street {

  private List<House> houses;
  private String name;
  private boolean isClosed;

  public Street(String name, boolean isClosed) {
    houses = new ArrayList<>();
    this.name = name;
    this.isClosed = isClosed;
  }

  public void addHouse(House house){
    houses.add(house);
  }

  public List<House> getHouses() {
    return houses;
  }

  public boolean isClosed() {
    return isClosed;
  }
}
