import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] grid;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new int[n][m];
		dp = new int[n][m][3];

		for (int i=0; i<n; i++) {
			grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i=1; i<n; i++) {
			for (int j=0; j<m; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}
		for (int i=0; i<m; i++) {
			Arrays.fill(dp[0][i], grid[0][i]);
		}

		for (int i=1; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (j == 0) {
					dp[i][j][0] = Math.min(dp[i-1][j + 1][1], dp[i-1][j + 1][2]) + grid[i][j];
					dp[i][j][1] = dp[i-1][j][0] + grid[i][j];
				} else if (j == m-1) {
					dp[i][j][1] = dp[i-1][j][2] + grid[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j - 1][1], dp[i-1][j - 1][0]) + grid[i][j];
				} else {
					dp[i][j][0] = Math.min(dp[i-1][j + 1][1], dp[i-1][j + 1][2]) + grid[i][j];
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + grid[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j - 1][1], dp[i-1][j - 1][0]) + grid[i][j];
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i=0; i<m ;i++) {
			for (int j=0; j<3; j++) {
				ans = Math.min(ans, dp[n-1][i][j]);
			}
		}
		System.out.println(ans);
	}
}