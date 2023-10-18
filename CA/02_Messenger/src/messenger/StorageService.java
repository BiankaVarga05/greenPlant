package messenger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StorageService {
    private Path path;

    public StorageService(Path path) {
        this.path = path;
    }

    public void writeAll(List<String> lines) throws IOException {
        Files.write(path, lines);
    }

    public List<String> readAll() throws IOException {
        try {
            return Files.readAllLines(path);
        } catch (NoSuchFileException e) {
            return new ArrayList<>();
        }
    }
}
