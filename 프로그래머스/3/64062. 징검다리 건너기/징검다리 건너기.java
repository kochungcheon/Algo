import java.util.*;
class Solution {
    private boolean check(int m, int k, int[] stones) {
        int len = stones.length;
        int cnt = 0;
        for (int i=0; i<len; i++) {
            if (stones[i] < m) {
                cnt ++;
                if (cnt >= k) return false;
            } else {
                cnt = 0;
            }
            
        }
        return true;
    }
    public int solution(int[] stones, int k) {
        int s = 0;
        int e = 200000000;
        int answer = 0;
        while (s <= e) {
            int m = (s+e) / 2;
            if (check(m, k, stones)) {
                s = m + 1;
                answer = Math.max(m, answer);
            } else {
                e = m - 1;
            }
        }
        
        return answer;
    }
}