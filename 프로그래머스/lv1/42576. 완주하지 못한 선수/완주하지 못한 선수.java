import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<completion.length; i++){
            map.put(completion[i], map.getOrDefault(completion[i], 0)+1);
        }
        for (String part : participant){
            if (map.getOrDefault(part, 0) == 0){
                return part;
            }
            map.put(part, map.get(part)-1);
        }
        return answer;
    }
}