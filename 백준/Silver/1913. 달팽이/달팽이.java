import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];

        int num = 1;

        int x = n/2;
        int y = n/2;

        int canGo = 0;

        while (true) {
            canGo++;
            for (int i=0; i<canGo; i++) {
                grid[x][y] = num++;
                x--;
            }

            if (num > n*n) break;

            for (int i=0; i<canGo; i++) {
                grid[x][y] = num++;
                y++;
            }

            canGo++;
            for (int i=0; i<canGo; i++) {
                grid[x][y] = num++;
                x++;
            }

            for (int i=0; i<canGo; i++) {
                grid[x][y] = num++;
                y--;
            }
        }


        // 정답 출력
        x = 0;
        y = 0;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sb.append(grid[i][j] + " ");
                if (grid[i][j] == m) {
                    x = i+1;
                    y = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(x + " " + y);
        System.out.println(sb);
    }
}