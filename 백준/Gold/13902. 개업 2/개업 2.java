

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] woks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int size = 20001;
		boolean[] visit = new boolean[size];
		for (int wok : woks) {
			visit[wok] = true;
		}
		for (int i = 0; i <m-1; i++) {
			for (int j = i + 1; j <m; j++) {
				int tmp = woks[i] + woks[j];
				if (tmp <= n) {
					visit[tmp] = true;
				}
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < size; i++) {
			if (visit[i]) {
				list.add(i);
			}
		}

		long[] dp = new long[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int l : list) {
			for (int i = l; i<=n; i++) {
				if (dp[i-l] != Integer.MAX_VALUE && dp[i-l] + 1 < dp[i]) {
					dp[i] = dp[i-l] + 1;
				}
			}
		}
		System.out.println(dp[n] < Integer.MAX_VALUE ? dp[n] : -1);
	}
}
// 필요 이상 웍 사용 x
