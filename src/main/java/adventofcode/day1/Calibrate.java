package adventofcode.day1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Calibrate {

    public static int part1(ArrayList<String> fileLines) {
        int answer = 0;
        for (String line : fileLines) {
            line = line.replaceAll("\\D", "");
            if (line.length() == 1) {
                line = line + line;
                answer += Integer.parseInt(line);
            } else {
                char[] charLine = line.toCharArray();
                String newLine = "" + charLine[0] + charLine[charLine.length - 1];
                answer += Integer.parseInt(newLine);
            }
        }
        return answer;
    }

    public static int part2(ArrayList<String> fileLines) {
        int answer = 0;
        Map<String, Integer> map = Map.of("one", 1,
                "two", 2, "three", 3,
                "four", 4, "five", 5,
                "six", 6, "seven", 7,
                "eight", 8, "nine", 9);
        for (String line : fileLines) {
            String value = null;
            String value2 = null;
            lineLoop:
            for (int i = 0; i < line.length(); i++) {
                String letter = line.substring(i, i + 1);
                try {
                    Integer.parseInt(letter);
                    value = letter;
                    break;
                } catch (Exception e) {
                    Set<String> numbers = map.keySet();
                    for (String number : numbers) {
                        if (line.substring(i).startsWith(number))
                            value = map.get(number).toString();
                        if (value != null)
                            break lineLoop;
                    }
                }
            }
            lineLoop:
            for (int i = line.length(); i > 0; i--) {
                String letter = line.substring(i - 1, i);
                try {
                    Integer.parseInt(letter);
                    value2 = letter;
                    break;
                } catch (Exception e) {
                    Set<String> numbers = map.keySet();
                    for (String number : numbers) {
                        if (line.substring(i - 1).startsWith(number))
                            value2 = map.get(number).toString();
                        if (value2 != null)
                            break lineLoop;
                    }
                }
            }
            answer += Integer.parseInt(value + value2);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(part1(ReadFile.fileToString()));
        System.out.println(part2(ReadFile.fileToString()));
    }
}