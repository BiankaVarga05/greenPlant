import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // initialisation with new
        String[] array = new String[3]; // empty array

        // initialisation with literal
        String[] mentors = { "Jazmin", "Riel", "Mate" };

        // printing
        System.out.println(mentors); // memory address
        System.out.println(Arrays.toString(mentors)); // actual elements

        // accessing an element
        System.out.println(mentors[0]);

        // out of bounds
        System.out.println(mentors[3]); // causes error

        // replacing an element
        mentors[2] = "Bela";
        System.out.println(Arrays.toString(mentors));

        // number of elements
        System.out.println(mentors.length);

        // accessing all elements
        for (int i = 0; i < mentors.length; i++) {
            String mentor = mentors[i];
            System.out.println(mentor);
        }

        // accessing all elements backwards
        for (int i = mentors.length - 1; i >= 0; i--) {
            System.out.println(mentors[i]);
        }

        // accessing all elements with for-each loop
        for (String mentor : mentors) {
            System.out.println(mentor);
        }

        // sorting
        Arrays.sort(mentors); // changes the mentors array
        System.out.println(Arrays.toString(mentors));
    }
}
