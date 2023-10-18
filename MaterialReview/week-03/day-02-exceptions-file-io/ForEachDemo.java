public class ForEachDemo {
    public static String getString(boolean hasName) {
        if (hasName) {
            return "Joe";
        }
        return null; // Indicates that the name is empty
    }

    public static void main(String[] args) {
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        for (int i = 0; i < days.length; i++) {
            String day = days[i];
            day = "Monday"; // Won't change array elements
        }

        for (String day : days) {
            day = "Monday"; // Won't change array elements
        }

        String name = getString(false); // May be `null`
        System.out.println(name);
    }
}
