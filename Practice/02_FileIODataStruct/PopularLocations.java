// In the data.csv file you can find data about tourist information.
// The first data in a row is the city, the second is the rating and the third is how many days has the tourist spent on that city.
// Create a getTheMostPopularLocation() function, with takes the filename as a parameter and calculates the sum of those days for every city, where the rating was at least ok.
// The function returns the name of the most popular city.
// If there is no such city but there was at least one data in the file, it returns the following: "No city with ok or good rating."
// If the filename was null or the file is empty, it throws an IllegalArgumentException.
// If there was some other problem during reading the file (e.g. the path is not correct), it prints "Error reading the file." to the console and exits.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// {
//      Budapest: 8,
//      Siófok: 20,
//      Szeged: 4,
//      Pécs: 11
// }  ---> Siófok

public class PopularLocations {
    public static String getTheMostPopularLocation(String fileName){
        String mostPopularCity = "";

        if(fileName == null){
            throw new IllegalArgumentException("The filename is null");
        }

        Path inputFilePath = Paths.get(fileName);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(inputFilePath);
        } catch (IOException e){
            System.out.println("Error reading the file.");
            System.exit(1);
        }

        if(lines.isEmpty() /* vagy lines.size() == 0*/){
            throw new IllegalArgumentException("The file is empty.");
        }

        HashMap<String, Integer> citiesWithStayings = new HashMap<>();
        for (String line : lines){
            String[] dataOfLine = line.split(",");
            String rating = dataOfLine[1];

            if(rating.equals("ok") || rating.equals("good")){
                String city = dataOfLine[0];
                Integer days = Integer.parseInt(dataOfLine[2]);

                if(!citiesWithStayings.containsKey(city)){
                    citiesWithStayings.put(city, days);
                } else {
                    Integer oldDays = citiesWithStayings.get(city);
                    Integer newDays = oldDays + days;
                    citiesWithStayings.replace(city, newDays);
                }
            }
        }

        if(citiesWithStayings.isEmpty()){
            return "No city with ok or good rating.";
        }

        Integer maxStaying = -1;
        for (Map.Entry<String, Integer> entry : citiesWithStayings.entrySet()){
            if(entry.getValue() > maxStaying){
                maxStaying = entry.getValue();
                mostPopularCity = entry.getKey();
            }
        }

        return mostPopularCity;
    }

    public static void main(String[] args) {
        System.out.println(getTheMostPopularLocation("src/data.csv"));
    }
}
