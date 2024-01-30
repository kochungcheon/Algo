import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> { return o1[1]-o2[1]; });
        
        int idx = -1;
        
        for (int[] target : targets) {
            if (idx == -1) {
                answer++;
                idx = target[1] - 1;
                continue;
            }
            
            if (idx >= target[0] && idx <= target[1]) continue;
            
            answer++;
            idx = target[1] - 1;
        }
        
        return answer;
    }
}