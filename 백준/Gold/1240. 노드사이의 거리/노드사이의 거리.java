import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visit;
	static class Pair {
		int idx;
		int dis;
		public Pair(int idx, int dis) {
			this.dis = dis;
			this.idx = idx;
		}
	}
	static List<List<Pair>> adj = new ArrayList();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i=0; i<=N; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Pair(b, d));
			adj.get(b).add(new Pair(a, d));
		}
		for (int i=0; i<M; i++) {
			visit = new boolean[N+1];

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dfs(a, b, 0);
		}
	}

	private static void dfs(int a, int b, int ans) {
		visit[a] = true;
		for (Pair now : adj.get(a)) {
			if (visit[now.idx]) continue;
			if (now.idx == b) {
				System.out.println(ans + now.dis);
				return;
			}

			dfs(now.idx, b, ans + now.dis);
		}
	}
}
