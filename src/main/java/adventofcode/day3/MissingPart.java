package adventofcode.day3;

import java.util.ArrayList;

public class MissingPart {

    public static void main(String[] args) {
        System.out.println(checkGears(ReadFile.fileToString()));
        System.out.println(checkGearsPart2(ReadFile.fileToString()));
    }

    public static int checkGears(String[] lines) {
        int answer = 0;
        char[] symbols = {'*', '%', '-', '#', '/', '=', '$', '&', '@', '+'};
        for (char symbol : symbols) {
            for (int i = 0; i < lines.length; i++) {
                char[] charArray = lines[i].toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    if (charArray[j] == symbol) {
                        // Check horizontal
                        if (j > 0 && Character.isDigit(charArray[j - 1])) {
                            answer += parseMultiDigitNumber(lines[i], j - 1);
                        }
                        if (j < charArray.length - 1 && Character.isDigit(charArray[j + 1])) {
                            answer += parseMultiDigitNumber(lines[i], j + 1);
                        }
                        if (i > 0 && !Character.isDigit(lines[i - 1].charAt(j))) {
                            if (j > 0 && Character.isDigit(lines[i - 1].charAt(j - 1))) {
                                answer += parseMultiDigitNumber(lines[i - 1], j - 1);
                            }
                            if (j < charArray.length - 1 && Character.isDigit(lines[i - 1].charAt(j + 1))) {
                                answer += parseMultiDigitNumber(lines[i - 1], j + 1);
                            }
                        } else if (i > 0 && Character.isDigit(lines[i - 1].charAt(j))) {
                            answer += parseMultiDigitNumber(lines[i - 1], j);
                        }
                        if (i < lines.length - 1 && !Character.isDigit(lines[i + 1].charAt(j))) {
                            if (i < lines.length - 1 && j > 0 && Character.isDigit(lines[i + 1].charAt(j - 1))) {
                                answer += parseMultiDigitNumber(lines[i + 1], j - 1);
                            }
                            if (i < lines.length - 1 && j < charArray.length - 1 && Character.isDigit(lines[i + 1].charAt(j + 1))) {
                                answer += parseMultiDigitNumber(lines[i + 1], j + 1);
                            }
                        } else if (i < lines.length - 1 && Character.isDigit(lines[i + 1].charAt(j))) {
                            answer += parseMultiDigitNumber(lines[i + 1], j);
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static int checkGearsPart2(String[] lines) {
        int answer = 0;
        char symbol = '*';
        for (int i = 0; i < lines.length; i++) {
            char[] charArray = lines[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == symbol) {
                    // Check horizontal
                    ArrayList<Integer> checkGear = new ArrayList<>();
                    if (j > 0 && Character.isDigit(charArray[j - 1])) {
                        checkGear.add(parseMultiDigitNumber(lines[i], j - 1));
                    }
                    if (j < charArray.length - 1 && Character.isDigit(charArray[j + 1])) {
                        checkGear.add(parseMultiDigitNumber(lines[i], j + 1));
                    }
                    if (i > 0 && !Character.isDigit(lines[i - 1].charAt(j))) {
                        if (j > 0 && Character.isDigit(lines[i - 1].charAt(j - 1))) {
                            checkGear.add(parseMultiDigitNumber(lines[i - 1], j - 1));
                        }
                        if (j < charArray.length - 1 && Character.isDigit(lines[i - 1].charAt(j + 1))) {
                            checkGear.add(parseMultiDigitNumber(lines[i - 1], j + 1));
                        }
                    } else if (i > 0 && Character.isDigit(lines[i - 1].charAt(j))) {
                        checkGear.add(parseMultiDigitNumber(lines[i - 1], j));
                    }
                    if (i < lines.length - 1 && !Character.isDigit(lines[i + 1].charAt(j))) {
                        if (i < lines.length - 1 && j > 0 && Character.isDigit(lines[i + 1].charAt(j - 1))) {
                            checkGear.add(parseMultiDigitNumber(lines[i + 1], j - 1));
                        }
                        if (i < lines.length - 1 && j < charArray.length - 1 && Character.isDigit(lines[i + 1].charAt(j + 1))) {
                            checkGear.add(parseMultiDigitNumber(lines[i + 1], j + 1));
                        }
                    } else if (i < lines.length - 1 && Character.isDigit(lines[i + 1].charAt(j))) {
                        checkGear.add(parseMultiDigitNumber(lines[i + 1], j));
                    }
                    if (checkGear.size() == 2)
                        answer += checkGear.get(0) * checkGear.get(1);
                }
            }
        }
        return answer;
    }


    private static int parseMultiDigitNumber(String line, int startIndex) {
        int reset = startIndex;
        StringBuilder numberBuilder = new StringBuilder();
        while (startIndex >= 0 && Character.isDigit(line.charAt(startIndex))) {
            numberBuilder.insert(0, line.charAt(startIndex));
            startIndex--;
            if (numberBuilder.length() == 3)
                return Integer.parseInt(numberBuilder.toString());
        }
        if (numberBuilder.length() <= 2) {
            startIndex = reset + 1;
        } else {
            startIndex = reset;
        }
        while (startIndex < line.length() && Character.isDigit(line.charAt(startIndex))) {
            numberBuilder.append(line.charAt(startIndex));
            startIndex++;
        }
        return Integer.parseInt(numberBuilder.toString());
    }
}

