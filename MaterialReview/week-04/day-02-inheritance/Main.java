import GFA.Mentor;
import GFA.Person;
import GFA.Student;
import GFA.GFMember;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person jozsef = new Person("József", 2, "male");
//        jozsef.name = "József";
//        jozsef.age = 2;
//        jozsef.gender = "male";
        jozsef.introduce();
        jozsef.work();
        System.out.println();

        GFMember klara = new GFMember("Klára", 22, "female", 123);
//        klara.name = "Klára";
//        klara.age = 22;
//        klara.gender = "female";
//        klara.chipCode = 123;
        klara.introduce();
        klara.work();
        System.out.println();

        ArrayList<String> classes = new ArrayList<>();
        classes.add("Shamrock");
        Mentor jazmin = new Mentor("Jázmin", 20, "female", 456, classes);
//        jazmin.name = "Jázmin";
//        jazmin.age = 20;
//        jazmin.gender = "female";
//        jazmin.chipCode = 456;
//        jazmin.assignedClasses = classes;
        jazmin.introduce();
        jazmin.work();
        jazmin.work(10, 5);
        System.out.println();

        Student gyula = new Student("Gyula", 16, "male", 789, "Shamrock");
//        gyula.name = "Gyula";
//        gyula.age = 16;
//        gyula.gender = "male";
//        gyula.chipCode = 789;
//        gyula.className = "Shamrock";
        gyula.introduce();
        gyula.work();
        System.out.println(gyula.getName());
        gyula.setName("Gyuszi");
        System.out.println(gyula.getName());
        System.out.println();

        System.out.println(gyula);
        System.out.println(Person.createdPersons);


        System.out.println();
        ArrayList<Person> everyOne = new ArrayList<>();
        everyOne.add(gyula);
        everyOne.add(jazmin);
        everyOne.add(klara);
        everyOne.add(jozsef);

//        for (Person someOne : everyOne){
//            System.out.println(someOne.getClass().getSimpleName());
//            someOne.introduce();
//            System.out.println();
//        }

        List<GFMember> foxers = new ArrayList<>();
        for(Person someOne : everyOne){
            if(someOne instanceof GFMember){
                foxers.add((GFMember) someOne);  // explicit
            }
        }

        // implicit
        Person betti = new Student("B", 10, "f", 123, "S");
        // System.out.println(betti.getClassName());

    }
}