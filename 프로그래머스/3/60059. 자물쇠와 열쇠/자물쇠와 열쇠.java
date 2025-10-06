import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length;
        int m = lock[0].length;
        
        int holeCnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (lock[i][j] == 0) holeCnt++;
            }
        }
        
        int[][] cur = key;
        
        for (int r=0; r<4; r++) {
            //
            for (int dx = -m + 1; dx <= n - 1; dx++) {
                for (int dy = -m + 1; dy <= n-1; dy++) {
                    if (check(cur, lock, dx, dy, holeCnt)) return true;
                }
            }
            cur = rotate(cur);
        }
        return answer;
    }
    private int[][] rotate(int[][] a) {
        int n = a.length;
        int[][] r = new int[n][n];
        for (int i=0;i<n; i++) {
            for (int j=0; j<n; j++) {
                r[j][n - 1 - i] = a[i][j];
            }
        }
        return r;
    }
    private boolean check(int[][] key, int[][] lock, int dx, int dy, int cnt) {
        int n = lock.length;
        int m = key.length;
        int filled = 0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                int x = dx + i;
                int y = dy + j;
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                
                int a = key[i][j];
                int b = lock[x][y];
                
                if (a == 1) {
                    if (b == 1) return false;
                    filled++;
                }
            }
        }
        return filled == cnt;
    }
}
// Lock 모든면에 key 모든 면을 360도 돌린다
// 0, 90, 180, 270 돌리는 메서드 구현
// 돌렸을 때, Lock을 다 채웠는 지 판별 (visit) 그리고 범위 밖 나가는 건 무시
// 최종적으로 visit 배열이 다 채워졌는 지 확인 하면 끗