import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> lru = new LinkedList<>();
        Set<String> cash = new HashSet<>();
        if (cacheSize == 0){
            return 5 * cities.length;
        }
        for (String city : cities){
            city = city.toLowerCase();
            if (cash.contains(city)){
                lru.remove(city);
                lru.addLast(city);
                answer += 1;
            } else{
                if (lru.size() < cacheSize){
                    cash.add(city);
                    lru.addLast(city);
                    answer += 5;
                }
                
                else{
                    cash.remove(lru.poll());
                    cash.add(city);
                    lru.addLast(city);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}