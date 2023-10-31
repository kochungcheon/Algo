import java.util.*;
public class Main {
	static int[][] grid;
	static int n, k;
	static int s, x, y;
	static class Pair {
		int x;
		int y;
		int time;
		public Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static Queue<Pair> q = new LinkedList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean canGo(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
	static void BFS() {
		while (!q.isEmpty()) {
			Pair now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int ntime = now.time + 1;
				// 시간이 되면 종료가 된다
				if (ntime > s) break;
				if (!canGo(nx, ny)) continue;
				if (grid[nx][ny] > 0) continue;
				// 색칠하기
				grid[nx][ny] = grid[now.x][now.y];
				q.add(new Pair(nx, ny, ntime));
			}

		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		for (int i=1; i<=k; i++) {
			for (int j=0; j<n; j++) {
				for (int h=0; h<n; h++) {
					if (grid[j][h] == i) {
						q.add(new Pair(j, h, 0));
					}
				}
			}
		}
		s = sc.nextInt();
		x = sc.nextInt() - 1;
		y = sc.nextInt() - 1;
		BFS();
		System.out.println(grid[x][y]);
	}
}
