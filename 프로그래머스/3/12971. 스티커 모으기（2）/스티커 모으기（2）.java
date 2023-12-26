import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1){
            return sticker[0];
        }else if(sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }


        int answer = 0;

        int len = sticker.length;
        int[] one_dp = new int[len+1];
        one_dp[0] = one_dp[1] = sticker[0];
        
        for (int i=2; i<len-1; i++) {
           one_dp[i] = Math.max(one_dp[i-1], one_dp[i-2] + sticker[i]);
            answer = Math.max(answer, one_dp[i]);
        }
        
        int[] two_dp = new int[len+1];
        two_dp[1] = sticker.length >= 2 ? sticker[1] : 0;
        
        for (int i=2; i<len; i++) {
           two_dp[i] = Math.max(two_dp[i-1], two_dp[i-2] + sticker[i]);
            answer = Math.max(answer, two_dp[i]);
        }
        
        return answer;
    }
}