import java.util.*;
class Solution {
    
    static int[][] grid;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        grid = new int[n][m];
        
        for (int[] puddle : puddles) {
            // 갈 수 없는 길 체크
            grid[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == -1) continue;
                if (i > 0) {
                    dp[i][j] += dp[i-1][j] % 1000000007;
                } 
                if (j > 0) {
                    dp[i][j] += dp[i][j-1] % 1000000007;
                }
            }
        }
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<m; j++) {
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        answer = dp[n-1][m-1];
        return answer % 1000000007;
    }
}