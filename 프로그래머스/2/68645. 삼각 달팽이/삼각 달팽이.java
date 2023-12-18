import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n+1) / 2];
        int[][] tmp = new int[n][n];
        int x = -1;
        int y = 0;
        int ans = 1;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (i % 3 == 0) {
                    x++;
                } 
                else if (i % 3 == 1) {
                    y++;
                }
                else {
                    x--;
                    y--;
                }
                tmp[x][y] = ans++;   
                }
            }
        int idx = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                answer[idx++] = tmp[i][j];
            }
        }
        return answer;
    }
}