package adventofcode.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<String> fileToString() {
        ArrayList<String> fileLines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/aoc-day2.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                fileLines.add(line);
            }
            br.close();
        } catch (IOException er) {
            throw new RuntimeException(er);
        }
        return fileLines;
    }
}
