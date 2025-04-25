package com.tetris;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreManager {
    private static final String FILE = "scores.txt";

    public static void saveScore(String name, int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write(name + ":" + score);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadTopScores() {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            lines = reader.lines()
                    .map(line -> line.split(":"))
                    .filter(arr -> arr.length == 2)
                    .map(arr -> new AbstractMap.SimpleEntry<>(arr[0], Integer.parseInt(arr[1])))
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(10)
                    .map(entry -> entry.getKey() + " - " + entry.getValue())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
