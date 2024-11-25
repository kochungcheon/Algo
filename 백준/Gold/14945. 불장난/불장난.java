import java.util.*;
import java.io.*;

public class Main {
    static int MOD = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 10][N + 10];

        dp[2][1] = 2;


        for (int i=3; i<=N; i++) {
            for (int j=1; j<= i - 1; j++) {
                dp[i][j] = (dp[i - 1][j] * 2 + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        int ans = 0;
        for (int i=1; i<N; i++) {
            ans = (ans + dp[N][i]) % MOD;

        }
        System.out.print(ans);
    }
}
