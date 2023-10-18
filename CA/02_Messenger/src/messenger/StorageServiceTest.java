package messenger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageServiceTest {
    private static Path path = Paths.get("test.txt");
    private StorageService storageService;

    @BeforeEach
    void setUp() throws IOException {
        storageService = new StorageService(path);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(path);
    }

    @Test
    void writeAll_writesLinesIntoFile() throws IOException {
        List<String> lines = Arrays.asList("x", "y");
        storageService.writeAll(lines);
        assertEquals(lines, Files.readAllLines(path));
    }

    @Test
    void readAll_readsLinesFromFile_whenFileExists() throws IOException {
        List<String> lines = Arrays.asList("x", "y");
        Files.write(path, lines);
        assertEquals(lines, storageService.readAll());
    }

    @Test
    void readAll_returnsEmptyList_whenFileDoesntExists() throws IOException {
        assertEquals(new ArrayList<>(), storageService.readAll());
    }
}