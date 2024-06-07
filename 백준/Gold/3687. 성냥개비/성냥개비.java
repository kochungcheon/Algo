import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = {0, 0, 1, 7, 4, 2, 0, 8};
		long[] dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[1] = 10;
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		for (int i = 8; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] * 10 + num[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			StringBuilder max = new StringBuilder();
			if (now % 2 == 1) {
				max.append("7");
				for (int j = 0; j < (now - 3) / 2; j++) {
					max.append("1");
				}
			} else {
				for (int j = 0; j < now / 2; j++) {
					max.append("1");
				}
			}

			System.out.println(dp[now] + " " + max);
		}
	}
}