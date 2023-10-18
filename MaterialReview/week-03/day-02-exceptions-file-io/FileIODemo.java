import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIODemo {
    public static void main(String[] args) {
        // Relative path to the working directory
        // (the root of the IntelliJ project by default)
        Path inputFilePath = Paths.get("hello.txt");

        // Reading a file as a string
        String content = null;
        try {
            content = Files.readString(inputFilePath);
        } catch (IOException e) {
            // IOException covers every special IO exception type e.g. FileNotFoundException
            System.out.println("Error reading the file");
            System.exit(1);
        }
        System.out.println(content); // "Hello World!\nHello Everyone!

        // Reading a file by lines
        List<String> lines = null;
        try {
            lines = Files.readAllLines(inputFilePath);
        } catch (IOException e) {
            System.out.println("Error reading the file");
            System.exit(1);
        }
        System.out.println(lines);

        // Splitting lines into words with 2 loops
        List<String> words = new ArrayList<String>();
        for (String line : lines) {
            String[] wordsOfLine = line.split(" ");

            for (String wordOfLine : wordsOfLine) {
                words.add(wordOfLine);
            }
        }
        System.out.println(words);

        // Splitting lines into characters with `addAll`
        List<String> characters = new ArrayList<String>();
        for (String line : lines) {
            String[] charsOfLine = line.split("");
            characters.addAll(Arrays.asList(charsOfLine));
        }
        System.out.println(characters);

        // Writing lines to a file (overwriting the content)
        Path outputFilePath = Paths.get("new-file.txt");
        try {
            Files.write(outputFilePath, lines);
        } catch (IOException e) {
            System.out.println("Error writing the file");
            System.exit(1);
        }

        // Appending lines to a file
        try {
            Files.write(outputFilePath, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing the file");
            System.exit(1);
        }

        // Writing a string to a file
        try {
            Files.writeString(outputFilePath, "foobar");
        } catch (IOException e) {
            System.out.println("Error writing the file");
            System.exit(1);
        }
    }
}
