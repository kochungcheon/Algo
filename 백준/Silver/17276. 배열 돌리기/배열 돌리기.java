
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, d;
	static int[][] grid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			grid = new int[n][n];
			for (int i = 0; i < n; i++) {
				grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			if (d > 0) {
				int now = (d / 45) % 8;

				for (int i = 0; i < now; i++) {
					right();
				}
			} else {
				d *= -1;
				int now = (d / 45) % 8;
				for (int i = 0; i < now; i++) {
					left();
				}
			}
			print();
		}
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void right() {
		int[][] copy = copy();
		// 주 대각선 -> 열
		for (int i = 0; i < n; i++) {
			grid[i][n / 2] = copy[i][i];
		}
		// 열 -> 부 대각선
		for (int i = 0; i < n; i++) {
			grid[i][n - 1 - i] = copy[i][n / 2];
		}
		// 부 대각선 -> 행
		for (int i = 0; i < n; i++) {
			grid[n / 2][i] = copy[n - 1 - i][i];
		}
		// 행 -> 주 대각선
		for (int i = 0; i < n; i++) {
			grid[i][i] = copy[n / 2][i];
		}
	}

	public static void left() {
		int[][] copy = copy();
		// 주 대각선 -> 행
		for (int i = 0; i < n; i++) {
			grid[n / 2][i] = copy[i][i];
		}
		// 행 -> 부 대각선
		for (int i = 0; i < n; i++) {
			grid[n-i-1][i] = copy[n / 2][i];
		}
		// 부 대각선 -> 열
		for (int i = 0; i < n; i++) {
			grid[i][n/2] = copy[i][n - 1 - i];
		}
		// 열 -> 주 대각선
		for (int i = 0; i < n; i++) {
			grid[i][i] = copy[i][n / 2];
		}
	}

	public static int[][] copy() {
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = grid[i][j];
			}
		}
		return copy;
	}
}
