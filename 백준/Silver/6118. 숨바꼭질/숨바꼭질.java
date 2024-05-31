import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<List<Integer>> adj = new ArrayList<>();
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj.get(s).add(e);
			adj.get(e).add(s);
		}
		Arrays.fill(visit, Integer.MAX_VALUE);
		bfs();
		int ans = N;
		int len = 0;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i] > len) {
				ans = i;
				len = visit[i];
				cnt = 1;
			} else if (visit[i] == len)
				cnt++;
		}
		System.out.print(ans + " " + len + " " + cnt);

	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		visit[1] = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : adj.get(now)) {
				int nextStep = visit[now] + 1;
				if (visit[next] <= nextStep)
					continue;
				visit[next] = nextStep;
				queue.add(next);
			}
		}

	}
}
