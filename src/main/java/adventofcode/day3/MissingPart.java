package adventofcode.day3;

public class MissingPart {
    static char[] symbols = {'*', '%', '-', '#', '/', '=', '$', '&', '@', '+'};

    public static void main(String[] args) {
        System.out.println(stringToChars(ReadFile.fileToString()));
    }

    public static int stringToChars(String[] lines) {
        int answer = 0;
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
                        if (i > 0 && Character.isDigit(lines[i - 1].charAt(j))) {
                            answer += parseMultiDigitNumber(lines[i - 1], j);
                        } else if (i > 0 && j > 0 && Character.isDigit(lines[i - 1].charAt(j - 1))) {
                            answer += parseMultiDigitNumber(lines[i - 1], j - 1);
                        } else if (i > 0 && j < charArray.length - 1 && Character.isDigit(lines[i - 1].charAt(j + 1))) {
                            answer += parseMultiDigitNumber(lines[i - 1], j + 1);
                        }
                        if (i < lines.length - 1 && Character.isDigit(lines[i + 1].charAt(j))) {
                            answer += parseMultiDigitNumber(lines[i + 1], j);
                        } else if (i < lines.length - 1 && j > 0 && Character.isDigit(lines[i + 1].charAt(j - 1))) {
                            answer += parseMultiDigitNumber(lines[i + 1], j - 1);
                        } else if (i < lines.length - 1 && j < charArray.length - 1 && Character.isDigit(lines[i + 1].charAt(j + 1))) {
                            answer += parseMultiDigitNumber(lines[i + 1], j + 1);
                        }
                    }
                }
            }
        }
        return answer;
    }

    // Helper method to parse multi-digit numbers
    private static int parseMultiDigitNumber(String line, int startIndex) {
        int reset = startIndex;
        StringBuilder numberBuilder = new StringBuilder();
        // Check left
        while (startIndex >= 0 && Character.isDigit(line.charAt(startIndex))) {
            numberBuilder.insert(0, line.charAt(startIndex));
            startIndex--;
            if (numberBuilder.length() == 3)
                return Integer.parseInt(numberBuilder.toString());
        }
        // Check right
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
