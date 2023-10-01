import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;  
        }

        Queue<String> lru = new LinkedList<>();
        Set<String> cacheSet = new HashSet<>();
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();  

            if (cacheSet.contains(city)) {
              
                lru.remove(city);
                lru.add(city);
                answer += 1;
            } else {
             
                if (lru.size() == cacheSize) {
                    String leastRecentlyUsed = lru.poll();  
                    cacheSet.remove(leastRecentlyUsed);
                }
                lru.add(city);
                cacheSet.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}
