package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Player> players = new ArrayList<>();
    players.add(new Player("Elemer", 2, 32));
    players.add(new Player("Izabella", 4, 25));
    players.add(new Player("Agota", 3, 33));
    players.add(new Player("Niki", 1, 16));
    players.add(new Player("Tamás", 5, 24));

    Collections.sort(players);

    introducePlayers(players);
  }

  public static void introducePlayers(List<Player> players ){
    for (Player player : players) {
      player.introduceYourself();
    }

    System.out.println();
  }
}
