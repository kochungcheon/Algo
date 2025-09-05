

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] A = new int[N + 1];
		for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

		long[][] dp = new long[N + 1][3];
		for (int r = 0; r < 3; r++) dp[0][r] = (r == 0 ? 0 : Long.MIN_VALUE / 4);

		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.max(dp[i - 1][0] + A[i], dp[i - 1][1] + 2L * A[i]);
			dp[i][1] = dp[i - 1][2] + 2L * A[i];
			dp[i][2] = dp[i - 1][0] + 2L * A[i];
		}

		long ans = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
		System.out.print(ans);
	}
}
