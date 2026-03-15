import java.util.*;

class Solution {
    static int GCD(int x, int y) {
        if (y == 0) return x;
        return GCD(y, x % y);
    }
    static int LCM(int x, int y) {
        return x * y / GCD(x, y);
    }
    static int N;
    static int[] visit;
    public int solution(int[][] signals) {
        
        N = signals.length;
        // LCM 기반으로 최대 배열 길이 구하기
        int totalLCM = 1;
        for (int[] s : signals) {
            totalLCM = LCM(Arrays.stream(s).sum(), totalLCM);
            // System.out.println(totalLCM);
        }
        
        visit = new int[totalLCM + 30];
        
        for (int[] s : signals) {
            int t = Arrays.stream(s).sum();
            for (int i=0; t * i <= totalLCM; i++) {
                int ys = s[0] + t * i + 1;
                int ye = s[0] + s[1] + t * i;
                
                // System.out.println(ys + " " + ye);
                    
                for (int j=ys; j<=ye; j++) {
                    visit[j]++;
                }
            }
        }
        
        for (int i=0; i<=totalLCM; i++) {
            if (visit[i] == N) return i;
        }
        
        return -1;
    }
}