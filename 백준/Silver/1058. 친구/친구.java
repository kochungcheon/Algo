import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, ans, tmp;
	static boolean[] visit;
	static String[] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new String[N];
		for (int i=0; i<N; i++) {
			grid[i] = br.readLine();
		}

		for (int i=0; i<N; i++) {
			visit = new boolean[N];
			visit[i] = true;
			tmp = -1;
			DFS(i, 0);
			for (boolean v : visit) {
				if (v) tmp++;
			}
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}


	private static void DFS(int now, int cur) {
		if (cur == 2) return;
		for (int i=0; i<N; i++) {
			if (grid[now].charAt(i) == 'N') continue;
			visit[i] = true;
			DFS(i, cur + 1);
		}
	}
}