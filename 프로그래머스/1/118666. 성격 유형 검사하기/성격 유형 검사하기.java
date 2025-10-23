import java.util.*;

class Solution {
    public String solution(String[] surveys, int[] choices) {
        String answer = "";
        int len = surveys.length;
        
        Map<Character, Integer> map = new HashMap<>();
        
        
        for (int i=0; i<len; i++) {
            char surveyTarget = surveys[i].charAt(0);
            int choice = choices[i];
            map.put(surveyTarget, 4 - choice + map.getOrDefault(surveyTarget, 0));
        }
        return new StringBuilder()
            .append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
            .append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
            .append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
            .append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N')
            .toString();
    }
}
// 1 2 3 4 5 6 7
// R T
// C F
// J M
// A N