// ‼️ This is an extra materal for digging deeper ‼️

public class StringBuilder {
    public static void main(String[] args) {
        // initializing
        String str = "this is my string"; // str is an immutable sequence of characters
        StringBuilder sb = new StringBuilder(str); // sb is a mutable sequence of characters 

        // append
        sb.append("123"); // sb is changed by this calling
        System.out.println(sb);
        System.out.println("------------");

        // delete
        sb.delete(1, 3);
        System.out.println(sb);
        System.out.println("------------");

        // reverse
        sb.reverse();
        System.out.println(sb);
        System.out.println("------------");

        // insert
        sb.insert(3, "new");
        System.out.println(sb);
        System.out.println("------------");

        // deleteCharAt
        sb.deleteCharAt(1);
        System.out.println(sb);
        System.out.println("------------");

        // replace
        sb.replace(0,8, "abc");
        System.out.println(sb);
        System.out.println(str);
        System.out.println("------------");
    }
}