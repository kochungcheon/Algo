import java.util.*;
import java.io.*;


public class Main {
	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int N, M, ans;
	static String[][] grid;
	static int[][] visit;

	static boolean canGo(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M && visit[x][y] == 0 && grid[x][y].equals("L");
	}

	static void BFS(int x, int y) {
		int tmp = 0;
		visit[x][y] = 1;
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (!canGo(nx, ny)) continue;
				visit[nx][ny] = visit[now.x][now.y] + 1;
				q.add(new Pair(nx, ny));
				tmp = Math.max(tmp, visit[nx][ny]);
			}
		}

		ans = Math.max(ans, tmp - 1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new String[N][M];
		for (int i=0; i<N; i++) {
			grid[i] = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
		}

		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				String now = grid[i][j];
				if (now.equals("L")) {
					visit = new int[N][M];
					BFS(i, j);
				}
			}
		}
		System.out.println(ans);
	}
}