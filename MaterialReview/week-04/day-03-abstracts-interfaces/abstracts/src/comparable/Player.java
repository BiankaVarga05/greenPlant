package comparable;

public class Player implements Comparable<Player> {
  private int ranking;
  private String name;
  private int age;

  public Player(String name, int ranking, int age) {
    this.name = name;
    this.ranking = ranking;
    this.age = age;
  }

  public void introduceYourself(){
    System.out.println("Name: " + name + ", ranking: " + ranking + ", age: " + age);
  }

  //region Help
/*if (this.ranking > other.ranking) {
  return 1;
} else if (this.ranking < other.ranking) {
  return -1;
}
return 0;*/
//endregion

  @Override
  public int compareTo(Player other) {
    // Ranking:
    /*if (this.ranking > other.ranking) {
      return 1;
    } else if (this.ranking < other.ranking) {
      return -1;
    }
    return 0;
  }
    // age
    if (this.age > other.age) {
      return 1;
    } else if (this.age < other.age) {
      return -1;
    }
    return 0;
  }*/

    return Integer.compare(this.ranking, other.ranking);

    // name
    //return other.name.compareTo(this.name);
  }
}
