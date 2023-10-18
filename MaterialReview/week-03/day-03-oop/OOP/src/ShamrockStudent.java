import java.awt.*;
import java.util.ArrayList;

public class ShamrockStudent {
  // Create a class representing a "Shamrock student"
  // It shall have a hairColor (Color)
  // It shall have an age (int)
  // It shall have a name (String)
  // It shall have knowledge (int)
  Color hairColor;
  int age;
  String name;
  int knowledge;
  static String gfaClassName = "Shamrock";
  static ArrayList<String> mentors = new ArrayList<>() ;
  static int studentCounter;

  public ShamrockStudent(int age, String name, int wisdom){
      this.age = age;
      this.name = name;
      knowledge = wisdom;
      studentCounter ++;
  }

  public ShamrockStudent(int age, String name, int wisdom, Color hairColor){
    this(age, name, wisdom);
    this.hairColor = hairColor;
    this.gfaClassName = gfaClassName;
  }

  // It shall be able to writeCode
  //  - print <name + " can write code">
  public void writeCode(){
    System.out.println(name + " can write code");
  }

  // It shall be able to dye hair
  //  - change hair color to the given one
  public void dyeHair(Color newColor){
    hairColor = newColor;
  }

  // It shall have a watchVideo method that receives the number of videos
  // and increases the knowledge by 3 / video
  public void watchVideo(int videosWatched){
    knowledge =  knowledge + (videosWatched * 3);
  }

  public String introduce (){
    return "Hi. My name is " + name + " and my age is " + age;
  }

  public static void initClass(String name){
    mentors.add(name);
  }

  public static void printMentorNames () {
    for (String mentor : mentors) {
      System.out.println(mentor);
    }
    // Does not work: cannot reach non-static data from static methods
    //System.out.println(knowledge);
  }
}

