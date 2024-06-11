import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int[][][] dp = new int[N][M][3];
		for (int i = 0; i < M; i++) {
			dp[0][i][0] = grid[0][i];
			dp[0][i][1] = grid[0][i];
			dp[0][i][2] = grid[0][i];
		}

		int[] dy = {-1, 0, 1};
		for (int i=1; i<N; i++) {
			for (int j=0; j<M; j++) {
				dp[i][j][0] = Integer.MAX_VALUE;
				dp[i][j][1] = Integer.MAX_VALUE;
				dp[i][j][2] = Integer.MAX_VALUE;
				for (int dir=0; dir<3; dir++) {
					int ny = dy[dir] + j;
					if (0 <= ny && ny < M) {
						for (int d=0; d<3; d++) {
							if (d == dir) continue;
							dp[i][j][d] =  Math.min(dp[i][j][d], dp[i-1][ny][dir] + grid[i][j]);
						}
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i=0; i<M; i++) {
			for (int d=0; d<3; d++) {
				ans = Math.min(ans, dp[N-1][i][d]);
			}
		}
		System.out.print(ans);
	}
}