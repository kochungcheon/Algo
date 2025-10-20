
import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 10007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] dp = new int[H + 1];
		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer blocks = new StringTokenizer(line);

			int[] prev = dp.clone();
			int[] ndp = Arrays.copyOf(prev, H + 1);

			while (blocks.hasMoreTokens()) {
				int b = Integer.parseInt(blocks.nextToken());
				if (b > H) continue;
				for (int h = b; h <= H; h++) {
					ndp[h] += prev[h - b];
					if (ndp[h] >= MOD) ndp[h] -= MOD;
				}
			}
			dp = ndp;
		}

		System.out.println(dp[H] % MOD);
	}
}
