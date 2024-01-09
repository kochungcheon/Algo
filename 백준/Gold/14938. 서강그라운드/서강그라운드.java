
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int num;
		int weight;
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	static int N, M, R;
	static int[] items;
	static ArrayList<ArrayList<Node>> adj;
	static int[] dists;
	static boolean[] visits;

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		adj = new ArrayList<>();
		for (int i=0; i<=N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj.get(s).add(new Node(e, w));
			adj.get(e).add(new Node(s, w));
		}

		dists = new int[N+1];
		visits = new boolean[N+1];

		int ans = 0;

		for (int i=1; i<=N; i++) {
			ans = Math.max(ans, dijkstra(i));
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int dijkstra(int start ) {
		 Arrays.fill(dists, Integer.MAX_VALUE);
		 Arrays.fill(visits, false);

		 PriorityQueue<Node> pq = new PriorityQueue<>();
		 pq.offer(new Node(start,0));
		 dists[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int num = now.num;

			if (!visits[num]) {
				visits[num] = true;

				for (Node node : adj.get(num)) {
					if (!visits[node.num] && dists[node.num] > dists[num] + node.weight) {
						dists[node.num] = dists[num] + node.weight;
						pq.add(new Node(node.num, dists[node.num]));
					}
				}
			}
		}

		int tmp = 0;

		for (int i=1; i<=N; i++) {
			if (dists[i] <= M) {
				tmp += items[i];
			}
		}
		return tmp;
	}
}
