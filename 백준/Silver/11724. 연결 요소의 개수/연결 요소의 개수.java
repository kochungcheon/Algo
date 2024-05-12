import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[] visit;
	static List<List<Integer>> adj = new ArrayList<>();
	static void Bfs(int cur) {
		for (int i=0; i<adj.get(cur).size(); i++) {
			if (visit[adj.get(cur).get(i)]) continue;
			visit[adj.get(cur).get(i)] = true;
			Bfs(adj.get(cur).get(i));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n+1];

		for (int i=0; i<n+1; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		int ans = 0;
		for (int i=1; i<=n; i++) {
			if (visit[i]) continue;
			Bfs(i);
			ans++;
		}
		System.out.println(ans);
	}
}
