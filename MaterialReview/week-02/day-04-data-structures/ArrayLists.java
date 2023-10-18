import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {
        // initializing - only ref. types
        // int[] grades = new int[10];
        List<Integer> grades = new ArrayList<>();

        // add elements
        grades.add(2);
        grades.add(5);
        grades.add(3);
        grades.add(0, 1);
        System.out.println(grades);
        System.out.println("-----------");

        // get an element
        System.out.println(grades.get(1));
        System.out.println("-----------");

        // update an element
        grades.set(0, 5);
        System.out.println(grades);
        System.out.println("-----------");

        // remove an element + number of elements
        grades.remove(grades.size() - 1);
        System.out.println(grades);
        System.out.println("-----------");

        // empty?
        System.out.println(grades.size() == 0);
        System.out.println(grades.isEmpty());
        System.out.println("-----------");

        // iterating
        for (int i = 0; i < grades.size(); i++) {
            System.out.println(grades.get(i));
        }
        System.out.println("-----------");

        for(Integer grade : grades){
            System.out.println(grade);
        }

        System.out.println("-----------");

        // search for an element
        System.out.println(grades.contains(1));
        System.out.println("-----------");

        // conversions
        List<String> myList = new ArrayList<>();
        String[] myArray = {"aa", "bb"};

        // Array -> List
        myList = Arrays.asList(myArray.clone());
        System.out.println(myList);
        System.out.println(myArray);

        System.out.println("-----------");

        // List -> Array
        String[] backToArray = myList.toArray(myArray.clone());
        System.out.println(Arrays.toString(backToArray));
    }
}
