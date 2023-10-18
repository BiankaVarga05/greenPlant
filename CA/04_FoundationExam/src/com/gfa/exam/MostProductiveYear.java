package com.gfa.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostProductiveYear {
    public static String mostProductiveYear(String filename) throws IOException {
        if (filename == null) {
            throw new IllegalArgumentException();
        }

        Path path = Paths.get(filename);
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (NoSuchFileException e) {
            // /path/to/foundation-exam/marvel.csv
            String fileName = path.getFileName().toString();
            String[] filenameParts = fileName.split("\\.");

            String studioName = fileName;
            if (filenameParts.length > 0) {
                studioName = filenameParts[0];
            }

            return "Cannot find studio " + studioName + ", please try again later.";
        }

        Map<String, Integer> frequencies = new HashMap<>();

        for (String line : lines) {
            String[] lineParts = line.split(",");
            String year = lineParts[1];

            if (frequencies.containsKey(year)) {
                Integer lastCount = frequencies.get(year);
                frequencies.put(year, lastCount + 1);
            } else {
                frequencies.put(year, 1);
            }
        }

        Integer largestCount = -1;
        String mostFrequentYear = null;

        for (String year : frequencies.keySet()) {
            Integer count = frequencies.get(year);

            if (count > largestCount) {
                largestCount = count;
                mostFrequentYear = year;
            }
        }

        return mostFrequentYear;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(mostProductiveYear("marvel.csv"));
        System.out.println(mostProductiveYear("nosuch.csv"));
    }
}
