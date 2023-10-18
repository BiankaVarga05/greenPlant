import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        // initializing - only ref. types
        Map<String, String> phoneBook = new HashMap<>();

        // add elements
        phoneBook.put("001", "Anna");
        phoneBook.put("002", "Béla");
        phoneBook.put("005", "Anna");
        System.out.println(phoneBook);
        System.out.println("--------------");

        // get elements
        System.out.println(phoneBook.get("002"));
        System.out.println("--------------");

        // remove elements
        // phoneBook.remove("001");
        // System.out.println(phoneBook);
        System.out.println("--------------");

        // get all values/keys -> no specific order
        System.out.println(phoneBook.values());
        System.out.println(phoneBook.keySet());
        System.out.println("--------------");

        // iterate
        for(Map.Entry<String, String> x : phoneBook.entrySet()){
            System.out.println(x);
        }

        // create a phonebook from the input array
        String[] input = {
                "Chris;000",
                "Anne;001",
                "Patrick;002",
                "Jude;003",
                "Chris;004"
        };

    }

}

