package adventofcode.day1;

import java.util.ArrayList;

public class Calibrate {

    public static int numbers(ArrayList<String> fileLines){
        int answer = 0;
        for (String line : fileLines){
            answer += Integer.parseInt(line);
        }
        return answer;
    }
}
