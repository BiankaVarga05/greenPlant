//region Data types:
// Single value: int, byte, short, double, boolean
// Some kind of collection of data: array, list
// Data association: hashmap
// Complex data and behavior (together): Class
//endregion

//region Keywords
// Class - blueprint, recepie, abstract, not concrete, <The Human>
// Instance - concrete, exists, has real properties, <One Human>
// Object - base class of all classes / instance
//endregion

// Constructor - a special method that is called when the instance is created with the new keyword
//        Its task is to set the initial state (fields) of the instance
// Instantiation - when we create a new instance with the new keyword
// Method vs Function
// How to use THIS, NEW keywords

//region task
// Create a class representing a "Shamrock student"
// It shall have a hairColor (Color)
// It shall have an age (int)
// It shall have a name (String)
// It shall have knowledge (int)

// It shall be able to writeCode
//  - print <name + " can write code">
// It shall be able to dye hair
//  - change hair color to the given one
// It shall be able to introduce oneself
//  - politely
// It shall have a watchVideo method that receives the number of videos
// and increases the knowledge by 3 / video
//endregion

import java.awt.*;
public class Main {
  public static void main(String[] args) {
    ShamrockStudent endre = new ShamrockStudent(7, "Endre", 100);
    //System.out.println(endre.age);
    //endre.age = 7;
    //endre.name = "Endre";
    //endre.hairColor = new Color(7, 80, 250);
    ShamrockStudent zsombor = new ShamrockStudent(4, "zsombor", 19);
    zsombor.writeCode();
    zsombor.dyeHair(new Color(5,200, 50));
    System.out.println(zsombor.knowledge);
    zsombor.watchVideo(2);
    System.out.println(zsombor.knowledge);
    System.out.println(zsombor.introduce());

    System.out.println(ShamrockStudent.gfaClassName);

    ShamrockStudent gyula = new ShamrockStudent(7, "Gyula", 20, new Color(5, 5, 7));
    System.out.println(ShamrockStudent.studentCounter);

    ShamrockStudent.initClass("Jázmin");
    System.out.println(ShamrockStudent.mentors.get(0));

    ShamrockStudent.printMentorNames();
  }
}
