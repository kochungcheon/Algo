import java.util.*;
import java.io.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> LRU = new ArrayList<>();
        for (String c : cities) {
            String city = c.toLowerCase();
            if (LRU.remove(city)) {
                answer++;
            } else {
                if (LRU.size() == cacheSize && LRU.size() > 0) {
                    LRU.remove(0);
                }
                answer += 5; 
            }
            if (LRU.size() < cacheSize) {
                 LRU.add(city);   
            }
        }
        return answer;
    }
}