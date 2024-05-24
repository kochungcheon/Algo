import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, CNT;
	static long[][] dp;
	static boolean[][][] isConstruction;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		CNT = Integer.parseInt(br.readLine());

		dp = new long[N + 1][M + 1];
		isConstruction = new boolean[N + 1][M + 1][2];

		for (int i = 0; i < CNT; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			isConstruction[Math.min(a, c)][Math.min(b, d)][a == c ? 1 : 0] = true;
		}
		dp[0][0] = 1;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (!isConstruction[i][j][0] && i + 1 <= N) {
					dp[i + 1][j] += dp[i][j];
				}
				if (!isConstruction[i][j][1] && j + 1 <= M) {
					dp[i][j + 1] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}