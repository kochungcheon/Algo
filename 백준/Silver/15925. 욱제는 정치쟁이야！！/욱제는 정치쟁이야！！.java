import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, flag;
	static int[][] grid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		flag = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		calR();
		calV();
		calR();
        calV();
		printAns();
	}

	private static void printAns() {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1) {
					ans++;
				} else {
					ans--;
				}
			}
		}
		if (flag == 1 && ans == N * N) {
			System.out.print(1);
		} else if (flag == 0 && ans == -N * N) {
			System.out.print(1);
		} else {
			System.out.print(0);
		}

	}

	public static void calR() {
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1) {
					cnt++;
				} else {
					cnt--;
				}
			}
			if (flag == 1 && cnt > 0) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = 1;
				}
			} else if (flag == 0 && cnt < 0) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = 0;
				}
			}
		}
	}

	public static void calV() {
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (grid[j][i] == 1) {
					cnt++;
				} else {
					cnt--;
				}
			}
			if (flag == 1 && cnt > 0) {
				for (int j = 0; j < N; j++) {
					grid[j][i] = 1;
				}
			} else if (flag == 0 && cnt < 0) {
				for (int j = 0; j < N; j++) {
					grid[j][i] = 0;
				}
			}
		}
	}
}
