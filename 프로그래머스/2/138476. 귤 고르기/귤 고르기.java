import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] count = new int[10_000_001];
        for (int t : tangerine){
            count[t]++;
        }
        Arrays.sort(count);
        for (int i=10_000_000; i >= 0; i--){
            if (k > 0){
                // System.out.println(count[i]);
                k -= count[i];
                answer++;
            }
        }
        return answer;
    }
}