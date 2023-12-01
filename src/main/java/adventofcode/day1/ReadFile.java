package adventofcode.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {


    public static ArrayList<String> fileToString() {
        ArrayList<String> fileLines = new ArrayList<>();

        ArrayList<String> values = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/aoc-day1.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^\\d]", "");
                fileLines.add(line);
            }
        } catch (IOException er) {
            throw new RuntimeException(er);
        }
        for (String line : fileLines) {
            if (line.length() == 1) {
                line = line + line;
                values.add(line);
            } else {
                char[] charLine = line.toCharArray();
                values.add("" + charLine[0] + charLine[charLine.length - 1]);
            }
        }
        return values;
    }
}
