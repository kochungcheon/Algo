
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		long[] dp = new long[N];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				dp[j] = Math.min(dp[j], Math.max(dp[i], (j - i) * (1 + Math.abs(arr[j] - arr[i]))));
			}
		}

		System.out.print(dp[N - 1]);
	}
}
