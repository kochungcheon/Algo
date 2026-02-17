import java.util.*;

class Solution {
    public long solution(int a, int b) {
        long s = (long) Math.min(a, b);
        long e = (long) Math.max(a, b);
        long answer = 0;
        for (long i=s; i<=e; i++) {
            answer+=i;
        }
       
        return answer;
    }
}