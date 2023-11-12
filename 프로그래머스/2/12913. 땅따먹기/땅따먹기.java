class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        // 초기값 세팅
        for (int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
            answer = Math.max(dp[0][i], answer);
        }
        
        for (int i=1; i<land.length; i++) {
            for (int h = 0; h<4; h++){
                
                for (int j=0; j<4; j++) {
                    // 같은 행을 밟을 수는 없다
                    if (h == j) continue;
                    dp[i][h] = Math.max(dp[i][h], land[i][h] + dp[i-1][j]);
                    answer = Math.max(answer, dp[i][h]);
                    
                }    
            }
            
        }

        
        return answer;
    }
}