import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (int i = 0; i < clothes.length; i++) {
            h.put(clothes[i][1], h.getOrDefault(clothes[i][1], 0) + 1);
        }
        for (String key: h.keySet()){
            answer *= h.get(key) + 1;
        }
        return answer - 1;
    }
}
