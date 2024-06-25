import java.util.*;
import java.io.*;
public class Main {
	static int N, M, K;
	static int[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		for (int i=0; i<M; i++) {
			grid[0][i] = 1;
		}
		for (int i=0; i<N; i++) {
			grid[i][0] = 1;
		}
		for (int i=1; i<N; i++) {
			for (int j=1; j<M; j++) {
				grid[i][j] = grid[i][j-1] + grid[i-1][j];
			}
		}

		if (K == 0 || N * M < K) {
			System.out.print(grid[N-1][M-1]);
		} else {
			int y = (K-1) % M;
			int x = (K-1) / M ;

			for (int i=y; i<M; i++) {
				grid[x][i] = grid[x][y];
			}

			for (int i=x; i<N; i++) {
				grid[i][y] = grid[x][y];
			}

			for (int i=x + 1; i<N; i++) {
				for (int j=y + 1; j<M; j++) {
					grid[i][j] = grid[i][j-1] + grid[i-1][j];
				}
			}
			System.out.print(grid[N-1][M-1]);
		}
	}
}