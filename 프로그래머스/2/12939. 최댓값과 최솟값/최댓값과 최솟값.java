import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int min = Integer.parseInt(sArr[0]);
        int max = Integer.parseInt(sArr[0]);
        
        for (String sa : sArr) {
            min = Math.min(min, Integer.parseInt(sa));
            max = Math.max(max, Integer.parseInt(sa));
        }
        String answer = String.valueOf(min) + " "+ String.valueOf(max);
        return answer;
    }
}