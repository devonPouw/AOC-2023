package adventofcode.day2;

import java.util.ArrayList;
public class GameChecker {
    public static int calculatePart1(ArrayList<String> fileLines) {
        int lineNumber = 1;
        int answer = 0;
        for (String games : fileLines) {
            boolean game = true;
            String[] splitGame = games.split(": ");
            String[] splitRounds = splitGame[1].split("; ");
           nextGame: for (String cubes : splitRounds) {
                String[] splitCubes = cubes.split(", ");
                for (String word : splitCubes){
                   String[] splitAmount = word.split(" ");
                   if (splitAmount[1].equals("red") && Integer.parseInt(splitAmount[0]) > 12 ||
                           splitAmount[1].equals("green") && Integer.parseInt(splitAmount[0]) > 13 ||
                           splitAmount[1].equals("blue") && Integer.parseInt(splitAmount[0]) > 14) {
                        game = false;
                       break nextGame;
                   }
                }
            }
            if (game)
                answer += lineNumber;
            lineNumber++;
        }

        return answer;
    }
    public static int calculatePart2(ArrayList<String> fileLines) {
        int answer = 0;
        for (String games : fileLines) {
            int red = 0;
            int green = 0;
            int blue = 0;
            String[] splitGame = games.split(": ");
            String[] splitRounds = splitGame[1].split("; ");
            for (String cubes : splitRounds) {
                String[] splitCubes = cubes.split(", ");
                for (String word : splitCubes){
                    String[] splitAmount = word.split(" ");
                    if (splitAmount[1].equals("red") && Integer.parseInt(splitAmount[0]) > red)
                        red = Integer.parseInt(splitAmount[0]);
                    if (splitAmount[1].equals("blue") && Integer.parseInt(splitAmount[0]) > blue)
                        blue = Integer.parseInt(splitAmount[0]);
                    if (splitAmount[1].equals("green") && Integer.parseInt(splitAmount[0]) > green)
                        green = Integer.parseInt(splitAmount[0]);
                }
            }
            answer += (green * blue * red);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(calculatePart1(ReadFile.fileToString()));
        System.out.println(calculatePart2(ReadFile.fileToString()));
    }
}
