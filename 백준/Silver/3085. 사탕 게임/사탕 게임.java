import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[][] grid = new String[N][N];
        for (int i=0; i<N; i++) {
            grid[i] = br.readLine().split("");
        }
        int max = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (j < N-1) {
                    swap(grid, i, j, i, j+1);
                    max = Math.max(max, getMaxCnt(grid, N));
                    swap(grid, i, j, i, j+1);
                }

                if (i < N-1) {
                    swap(grid, i, j, i+1, j);
                    max = Math.max(max, getMaxCnt(grid, N));
                    swap(grid, i, j, i+1, j);
                }
            }
        }
        System.out.println(max);
    }

    static void swap(String[][] grid, int x1, int y1, int x2, int y2) {
        String tmp = grid[x1][y1];
        grid[x1][y1] = grid[x2][y2];
        grid[x2][y2] = tmp;
    }

    static int getMaxCnt(String[][] grid, int N) {
        int tmpMax = 1;
        for (int i=0; i<N; i++) {
            int rawCnt = 1;
            int calCnt = 1;
            for (int j=0; j<N-1; j++) {
                if (grid[i][j].equals(grid[i][j+1])) {
                    rawCnt++;
                } else {
                    tmpMax = Math.max(tmpMax, rawCnt);
                    rawCnt = 1;
                }

                if (grid[j][i].equals(grid[j+1][i])) {
                    calCnt++;
                } else {
                    tmpMax = Math.max(tmpMax, calCnt);
                    calCnt = 1;
                }
            }
            tmpMax = Math.max(tmpMax, Math.max(rawCnt, calCnt));
        }
        return tmpMax;
    }
}