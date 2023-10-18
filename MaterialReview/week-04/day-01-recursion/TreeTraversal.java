import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeTraversal {
    public static List<Path> listDirectory(Path directory) throws IOException {
        List<Path> publicPaths = new ArrayList<>();
        for (Path path : Files.list(directory).collect(Collectors.toList())) {
            // Exclude hidden files (that start with '.')
            if (!path.getFileName().toString().startsWith(".")) {
                publicPaths.add(path);
            }
        }
        return publicPaths;
    }

    public static Path find(Path rootDir, Path fileName) throws IOException {
        System.out.println("rootDir = " + rootDir);
        List<Path> contents = listDirectory(rootDir);

        for (Path path : contents) {
            System.out.println("checking path = " + path);
            if (Files.isDirectory(path)) {
                // Recursive case
                Path foundPath = find(path, fileName);

                // Base case 1: found somewhere in the subdirectory
                if (foundPath != null) {
                    System.out.println("Base case / found");
                    return foundPath;
                }
            } else if (path.getFileName().equals(fileName)) {
                // Base case 2: found in this directory
                System.out.println("Base case / found");
                return path;
            }
        }

        // Base case 3: not found
        System.out.println("Base case / not found");
        return null;
    }

    public static void main(String[] args) {
        Path rootDir = Paths.get("/Users/szemate/Code/green-fox-academy/otocyon-shamrock-syllabus");
        Path fileName = Paths.get("hello.txt");

        try {
            Path result = find(rootDir, fileName);
            System.out.println("Result: " + result);
        } catch (IOException e) {
            System.out.println("File I/O error");
            System.exit(1);
        }
    }
}
