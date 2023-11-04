import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while (true) {
			index++;
			int n = sc.nextInt();
			if (n == 0) break;
			int[][] grid = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++){
					grid[i][j] = sc.nextInt();
				}
			}
			System.out.println("Problem " + index + ":"+" "+Solution(n, grid));
		}
	}
	static int[][] dist;
	static int dijkstra(int[][] grid) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0, 0));
		dist[0][0] = grid[0][0];
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		while (!q.isEmpty()) {
			Pair now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (canGo(nx, ny, grid.length)) {
					if (dist[nx][ny] > dist[now.x][now.y] + grid[nx][ny]) {
						dist[nx][ny] = dist[now.x][now.y] + grid[nx][ny];
						q.add(new Pair(nx, ny));
					}
				}

			}
		}
		return dist[grid.length-1][grid.length-1];
	}
	static boolean canGo(int x, int y, int n) {
		return 0<= x && x < n && 0 <= y && y < n;
	}
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static Integer Solution(Integer N, int[][] grid) {
		dist = new int[N][N];
		for (int[] d : dist) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		return dijkstra(grid);
	}
}
