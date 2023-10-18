import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestRatedMovies {

    public static String getTheBestMovie(){
        // 1. Read all lines from the file
        Path inputFilePath = Paths.get("src/movies.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(inputFilePath);
        } catch (IOException e){
            System.out.println("Error reading the file");
            System.exit(1);
        }
        // System.out.println(lines);

        // 2. Split title from rating
        // 3. Create a HashMap for movies with the sum of the ratings
        HashMap<String, Integer> moviesWithSumOfRatings = new HashMap<>();

        for (String line : lines){
           String[] movieWithRating = line.split("-");
           String movieTitle = movieWithRating[0];
           Integer rating = Integer.parseInt(movieWithRating[1]);
           // System.out.println(rating);
            if(!moviesWithSumOfRatings.containsKey(movieTitle)){
                moviesWithSumOfRatings.put(movieTitle, rating);
            } else {
                Integer oldRating = moviesWithSumOfRatings.get(movieTitle);
                Integer newRating = oldRating + rating;
                moviesWithSumOfRatings.replace(movieTitle, newRating);
            }
        }
        System.out.println(moviesWithSumOfRatings);

        // 4. Find the highest rating and return the title - holnap

        return "";
    }

    public static void main(String[] args) {
        // In the following text file ("movies.txt") you can find the last 3 ratings for some movies in this format: title-rating
        // Create a function, which finds the most popular movie (where the sum of the ratings is the highest) and return the title of the movie.
        // This example you should see 'Titanic'.
        System.out.println(getTheBestMovie());

    }
}
