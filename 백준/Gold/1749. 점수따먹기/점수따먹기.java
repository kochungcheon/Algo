import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] grid = new int[N][M];
		for (int i=0; i<N; i++) {
			grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int ans = Integer.MIN_VALUE;

		int[][] prefix = new int[N+1][M+1];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				prefix[i + 1][j + 1] = grid[i][j] + prefix[i + 1][j] + prefix[i][j+1] - prefix[i][j];
			}
		}

		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				for (int h=i; h<=N; h++) {
					for (int k=j; k<=M; k++) {
						ans = Math.max(ans, prefix[h][k] - prefix[i-1][k] - prefix[h][j-1] + prefix[i-1][j-1]);
					}
				}
			}
		}

		System.out.print(ans);
	}
}
