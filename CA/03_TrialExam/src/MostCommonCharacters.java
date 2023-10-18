import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class MostCommonCharacters {
    public static Map<Character, Integer> getTwoMostCommonCharacters(String filename) throws Exception {
        List<String> lines = readLines(filename);
        List<Character> characters = splitLines(lines);
        Map<Character, Integer> frequencies = getFrequencies(characters);
        Map<Character, Integer> results = new HashMap<>();

        if (frequencies.size() == 0) {
            return results;
        }

        Character mostFrequentChar = getMostFrequentCharacter(frequencies);
        Integer mostFrequentCharCount = frequencies.get(mostFrequentChar);
        results.put(mostFrequentChar, mostFrequentCharCount);

        frequencies.remove(mostFrequentChar);

        if (frequencies.size() > 0) {
            Character secondMostFrequentChar = getMostFrequentCharacter(frequencies);
            Integer secondMostFrequentCharCount = frequencies.get(secondMostFrequentChar);
            results.put(secondMostFrequentChar, secondMostFrequentCharCount);
        }

        return results;
    }

    public static List<String> readLines(String filename) throws Exception {
        Path path = Paths.get(filename);

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new Exception("File does not exist!");
        }
    }

    public static List<Character> splitLines(List<String> lines) {
        List<Character> characters = new ArrayList<>();

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                characters.add(line.charAt(i));
            }
        }

        return characters;
    }

    public static Map<Character, Integer> getFrequencies(List<Character> characters) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (Character character : characters) {
            if (frequencies.containsKey(character)) {
                Integer lastCount = frequencies.get(character);
                frequencies.put(character, lastCount + 1);
            } else {
                frequencies.put(character, 1);
            }
        }

        return frequencies;
    }

    public static Character getMostFrequentCharacter(Map<Character, Integer> frequencies) {
        Character mostFrequentChar = null;
        Integer mostFrequentCharCount = -1;

        for (Character character : frequencies.keySet()) {
            if (frequencies.get(character) > mostFrequentCharCount) {
                mostFrequentCharCount = frequencies.get(character);
                mostFrequentChar = character;
            }
        }

        return mostFrequentChar;
    }
}
