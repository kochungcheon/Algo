import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> lst = new ArrayList<>();
        while (n > 0) {
            lst.add((int) (n % 10));
            n /= 10;
        }
       
        
        int[] answer = new int[lst.size()];
        for (int i=0; i<lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        return answer;
    }
}