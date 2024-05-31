import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new long[N + 1];
		long tmp = arr[0];
		int s = 0;
		int e = 1;
		while (e <= N) {
			if (tmp >= K) {
				while (tmp >= K) {
					dp[e] = Math.max(dp[e], dp[s] + tmp - K);
					tmp -= arr[s++];
				}
			} else {
				dp[e] = Math.max(dp[e], dp[e - 1]);
				if (e == N)
					break;
				tmp += arr[e++];
			}
		}

		System.out.print(dp[N]);
	}

}