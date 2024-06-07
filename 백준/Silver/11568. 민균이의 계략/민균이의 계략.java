import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i=N-2; i>=0; i--) {
			for (int j=i+1; j<N; j++) {
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int ans = 0;
		for (int i=0; i<N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.print(ans);
	}
}
