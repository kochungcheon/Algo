import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] arr;
	static long[][] dp;
	static int maxNum = 20;
	static int target;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		target = arr[N-1];
		// N 번 까지 골랐을 때 몇 개 인지 저장
		dp = new long[N-1][maxNum+1];

		dp[0][arr[0]] = 1;
		for (int i=1; i<N-1; i++) {
			for (int j=0; j<=maxNum; j++) {
				if (dp[i-1][j] == 0) continue;
				// 20 이하
				if (j + arr[i] <= maxNum) {
					dp[i][j + arr[i]] += dp[i-1][j];
				}
				if (j - arr[i] >= 0) {
					dp[i][j - arr[i]] += dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N-2][target]);
	}
}