public class ShelfCleaner implements Cleanable {
  @Override
  public void clean(Room room) {
    room.cleanShelves();
  }
}
