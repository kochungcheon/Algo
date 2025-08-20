import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[1001][10];
		int MOD = 1234567;

		for (int i = 0; i <= 9; i++) {
			dp[1][i]++;
		}

		for (int i = 2; i <= 1000; i++) {
			for (int j = 0; j <= 9; j++) {
				switch (j) {
					case 0:
						dp[i][j] = dp[i - 1][7];
						break;
					case 1:
						dp[i][j] = (dp[i - 1][2] + dp[i - 1][4]) % MOD;
						break;
					case 2:
						dp[i][j] = (dp[i - 1][1] + dp[i - 1][5] + dp[i - 1][3]) % MOD;
						break;
					case 3:
						dp[i][j] = (dp[i - 1][2] + dp[i - 1][6]) % MOD;
						break;
					case 4:
						dp[i][j] = (dp[i - 1][1] + dp[i - 1][5] + dp[i - 1][7]) % MOD;
						break;
					case 5:
						dp[i][j] = (dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][6] + dp[i - 1][8]) % MOD;
						break;
					case 6:
						dp[i][j] = (dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][9]) % MOD;
						break;
					case 7:
						dp[i][j] = (dp[i - 1][4] + dp[i - 1][8] + dp[i - 1][0]) % MOD;
						break;
					case 8:
						dp[i][j] = (dp[i - 1][5] + dp[i - 1][7] + dp[i - 1][9]) % MOD;
						break;
					case 9:
						dp[i][j] = (dp[i - 1][8] + dp[i - 1][6]) % MOD;
						break;
				}
			}
		}
		while (T-- > 0) {
			int v = Integer.parseInt(br.readLine());
			int ans = 0;
			for (int index=0; index<=9; index++) {
				ans = (ans + dp[v][index]) % MOD;
			}
			System.out.println(ans);
		}
	}
}
