import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        boolean[] dp = new boolean[1000001];
        for (int i=0; i<len; i++){
            int tmp  = 0;
            for (int j=0; j<len; j++){
                tmp += elements[(i+j)%len];
                // System.out.println(tmp);
                dp[tmp] = true; 
            }
        }
        for (int i=0; i<1000001; i++){
            if (dp[i]){
                answer++;
            }
        }
        return answer;
    }
}