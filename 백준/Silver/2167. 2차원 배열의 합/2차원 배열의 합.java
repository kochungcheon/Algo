import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        // 배열 입력
        int[][] grid = new int[N+1][M+1];
        for (int i=1; i<=N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=1; j<=M; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1] + Integer.parseInt(row[j-1]);
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++) {
            String[] com = br.readLine().split(" ");
            int x1 = Integer.parseInt(com[0]);
            int y1 = Integer.parseInt(com[1]);
            int x2 = Integer.parseInt(com[2]);
            int y2 = Integer.parseInt(com[3]);

            int ans = grid[x2][y2] - grid[x2][y1-1] - grid[x1-1][y2] + grid[x1-1][y1-1];
            System.out.println(ans);
        }
    }
}
