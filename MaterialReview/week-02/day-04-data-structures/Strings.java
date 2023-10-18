import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        // 1. Primitive types/object types:
        int i1 = 5;
        double d1 = 2.5;
        char c = 'c';

        String s = "Jázmin";
        Integer i2 = 5; // wrapper class for int
        Double d2 = 2.5;


        // 2. String methods
        String s1 = "abcd";
        String s2 = "AbaBAB";
        String s3  = "xyzxyz";

        // lenght
        System.out.println(s1.length());
        System.out.println("------------");

        // upper/lower
        System.out.println(s1.toUpperCase());
        // s2 = s2.toLowerCase();
        System.out.println(s2.toLowerCase());
        System.out.println(s1);
        System.out.println("------------");

        // starts/ends
        System.out.println(s1.startsWith("a") || s1.startsWith("b"));
        System.out.println(s2.startsWith("a"));
        System.out.println("------------");

        // concat
        System.out.println(s1.concat(s2 + s3));
        System.out.println("------------");

        // charAt
        System.out.println(s1.charAt(1));
        // System.out.println(s1.charAt(1000)); Exception!
        System.out.println("------------");

        // indexOf
        System.out.println(s1.indexOf('c'));
        System.out.println(s3.indexOf("y", 2));
        System.out.println(s1.indexOf('q'));
        System.out.println("------------");

        // lastIndexOf
        System.out.println(s3.lastIndexOf('y'));
        System.out.println("------------");

        // substring
        System.out.println(s1.substring(1));
        // System.out.println(s1.substring(1, 8));
        System.out.println("------------");

        // replace
        System.out.println(s3.replace('x', 'a'));
        System.out.println(s3.replaceFirst("x", "a"));
        System.out.println("------------");

        // trim
        String s5 = "   asef      ";
        System.out.println(s5.trim());
        System.out.println("------------");

        // contains
        System.out.println(s1.contains("aB"));
        System.out.println("------------");

        // split
        String s6 = "ez a string tartalmaz space-eket";
        String[] splittedString = s6.split(" ");
        System.out.println(Arrays.toString(splittedString));
        System.out.println("------------");

        // compareTo
        String person1 = "Adam";
        String person2 = "Bela";
        String person3 = "Zita";
        String c1 = "a";
        String c2 = "A";
        System.out.println(person1.compareTo(person2));
        System.out.println(person1.compareTo(person1));
        System.out.println(person3.compareTo(person2));
        System.out.println(c1.compareTo(c2));
        System.out.println("------------");

        // chained methods
        System.out.println(person3.substring(1,3).contains("i"));
        System.out.println("------------");

        // excercise: get the last character of the longest word
        String sentece = "Get the last character of the longest word from the sentence";

    }
}
