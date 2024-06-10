import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] grid = new int[N][N];
			int[] rowSum = new int[N];
			int[] colSum = new int[N];
			
			for (int i = 0; i < N; i++) {
				grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for (int j = 0; j < N; j++) {
					rowSum[i] += grid[i][j];
					colSum[j] += grid[i][j];
				}
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken()) - 1;
				int c1 = Integer.parseInt(st.nextToken()) - 1;
				int r2 = Integer.parseInt(st.nextToken()) - 1;
				int c2 = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken());

				for (int j = r1; j <= r2; j++) {
					rowSum[j] += v * (c2 - c1 + 1);
				}

				for (int j = c1; j <= c2; j++) {
					colSum[j] += v * (r2 - r1 + 1);
				}
			}
			
			for (int sum : rowSum) {
				System.out.print(sum + " ");
			}
			System.out.println();
			for (int sum : colSum) {
				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}
}