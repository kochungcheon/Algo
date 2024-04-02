import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][N];

        for (int i=0; i<N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp = new int[N][3];

        for (int i=0; i<N; i++) {
            for (int j=0; j<3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=0; i<3; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i=1; i < N; i++) {
            // 지금
            for (int j=0; j<3; j++) {
                // 미래
                for (int h=0; h<3; h++) {
                    if (j==h) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][h] + grid[i][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            ans = Math.min(ans, dp[N-1][i]);
        }
        System.out.println(ans);
    }
}