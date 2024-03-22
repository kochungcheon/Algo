import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[][] grid = new String[N][N];
        
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().split("");
        }
        
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) { // 오른쪽과 교환
                    swap(grid, i, j, i, j + 1);
                    max = Math.max(max, getMaxCount(grid, N));
                    swap(grid, i, j, i, j + 1); // 원상 복구
                }
                
                if (i < N - 1) { // 아래와 교환
                    swap(grid, i, j, i + 1, j);
                    max = Math.max(max, getMaxCount(grid, N));
                    swap(grid, i, j, i + 1, j); // 원상 복구
                }
            }
        }
        
        System.out.println(max);
    }
    
    public static void swap(String[][] grid, int x1, int y1, int x2, int y2) {
        String temp = grid[x1][y1];
        grid[x1][y1] = grid[x2][y2];
        grid[x2][y2] = temp;
    }
    
    public static int getMaxCount(String[][] grid, int N) {
        int maxCount = 1;
        
        for (int i = 0; i < N; i++) {
            int rowCount = 1;
            int colCount = 1;
            for (int j = 1; j < N; j++) {
                // 행 검사
                if (grid[i][j].equals(grid[i][j - 1])) {
                    rowCount++;
                } else {
                    maxCount = Math.max(maxCount, rowCount);
                    rowCount = 1;
                }
                
                // 열 검사
                if (grid[j][i].equals(grid[j - 1][i])) {
                    colCount++;
                } else {
                    maxCount = Math.max(maxCount, colCount);
                    colCount = 1;
                }
            }
            maxCount = Math.max(maxCount, Math.max(rowCount, colCount)); // 마지막 비교에서 최대값 업데이트
        }
        
        return maxCount;
    }
}
