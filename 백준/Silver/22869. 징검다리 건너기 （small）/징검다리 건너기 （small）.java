import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static boolean[] dp;

	static boolean cal(int i, int j) {
		return (j - i) * (Math.abs(arr[i] - arr[j]) + 1) <= K;
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	public static void main(String[] args) throws IOException {
		input();
		dp = new boolean[N];

		dp[0] = true;
		for (int i = 0; i < N - 1; i++) {
			if (dp[i]) {
				for (int j = i + 1; j < N; j++) {
					if (cal(i, j)) {
						dp[j] = true;
					}
				}
			}
		}

		System.out.print(dp[N - 1] ? "YES" : "NO");

	}
}