
import java.util.*;
import java.io.*;

public class Main {
	static int ans;
	static int N, K;
	static int[][] board;
	static boolean[][] visit;
	static int[] dy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dy = new int[] {-1, 1, K};
		board = new int[2][N];
		visit = new boolean[2][N];

		for (int i=0; i<2; i++) {
			String tmp = br.readLine();
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
			}
		}
		DFS(0, 0, 0);
		System.out.println(ans);
	}

	private static void DFS(int x, int y, int time) {
		if (ans == 1) return;
		if (time >= N) return;
		for (int i=0; i<3; i++) {
			int ny = y + dy[i];
			int nx = i==2 ? (x+1) % 2 : x;
			if (ny >= N) {
				ans = 1;
				return;
			}
			// 현재 시간에 갈 수 없는 곳으로 가거나, 위험한 장소로 간 경우
			if (time >= ny || board[nx][ny] == 0) continue;
			if (visit[nx][ny]) continue;
			visit[x][y] = true;
			DFS(nx, ny, time+1);
			visit[x][y] = false;
		}
	}
}