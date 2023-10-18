import java.util.Scanner;

public class Main {
  //region Basic concepts
  // Parameters of Java programming language
  // - High level
  // - Imperative
  // - ObjectOriented
  // - Statically typed
  // - Platform independent

  // Abbrevations:
  // JVM, JRE, JDK
  // IDE

  // What is the type of a Java file?
  // How to run a Java "program"?
  // javac Main.java --> compile
  // java main --> run

  // What is the entry point of the software?
  // What is the naming convention called camel case?
  //endregion

  public static void main(String[] args) {
    // Let us create a variable of type "int" that stores the number of the students
    // int numberOfStudents = 18;
    int numberOfStudents;   // Declaration
    numberOfStudents = 18;  // Assignment

    // What is declaration?
    // What is value assignment?
    // What kind of variable types do you know?
    // String, char, boolean, double, float, byte, short, long, int

    // What does "=" mean?
    // Shall be equal to ...

    // How can I increment a number by one (more ways)
    numberOfStudents++;
    numberOfStudents = numberOfStudents + 1;
    numberOfStudents +=1;

    // How is the code executed?
    // What is String concatenation?
    String foreName = "Robert";
    String lastName = "Taylor";
    //String fullName = foreName + " " + lastName;
    //System.out.println(foreName + " " + lastName);

    //region What kind of operators do we know?

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html
    // assignment (=)
    // arithmetic (+, -, *, /, %)

    // What will this print?
    // System.out.println(1 + 2 * 3);

    // What will this print?
    // System.out.println(1 * 2 + 3);

    // What will this print?
    // System.out.println(324 / 36 / 3);

    // https://introcs.cs.princeton.edu/java/11precedence/

    // What will this print?
    // System.out.println(324 / (36 / 3));

    // How can I test if a number is even?
    // System.out.println(numberOfStudents%2 == 0);

    // unary (+, -, ++, --, !)
    // System.out.println(!true);

    // equality (==, !=, >, >=, <, <=)
    // conditional (&&, ||, ternary)
    //endregion

    boolean isRainy = false;
    boolean isCold = true;
    boolean isWindy = false;
    boolean letsGoForWalk = !isRainy && !isCold && !isWindy; // Ha jó az idő
    // System.out.println(letsGoForWalk);
    // boolean walk2 = isCold == isRainy == isWindy == false;
    // System.out.println(walk2);
    boolean letUsWearCoat = isRainy || isCold || isWindy; // Ha szükséges
    // System.out.println(letUsWearCoat);

    // Ask for new numbers from the user until you get a bigger one than 500:
    // get a number
    // if the number is < 500 --> ask for a new one
    /*System.out.printf("Lécci lécci aggyá egy számot");
    Scanner scanner = new Scanner(System.in);
    int numberFromUser = scanner.nextInt();
    // System.out.println("The user has given: "  + numberFromUser);

    while (numberFromUser < 500) {
      System.out.printf("Lécci lécci aggyá többet");
      numberFromUser = scanner.nextInt();
    }
    System.out.printf("Végre");*/

     /*do {
      System.out.printf("Lécci lécci aggyá többet");
      numberFromUser = scanner.nextInt();
    } while (numberFromUser < 500);

    System.out.printf("Végre");*/

    // What will this print?
    int b = 20;
    // System.out.println(b++);
    // System.out.println(b);


    // Print the first 10 numbers / each in a new line
    /*for (int i = 1; i <11 ; i++) {
      System.out.println(i);
    }*/


    // Print the number sequences from 0 to 5
    // 0
    // 0 1
    // 0 1 2
    // 0 1 2 3
    // ...
    /*for (int i = 0; i <3 ; i++) {
      System.out.println("Külső");
      for (int j = 0; j <4 ; j++) {
        System.out.println("Belső");
      }
    }*/

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }

    // Ask for a language from the user
    // Say "Hi" depending on the language the user gives
    // Hun --> Sziasztok
    // Eng --> Hi
    // Sp --> Hola
    // egyik sem --> Bye


    // Make it with switch
  }
}
