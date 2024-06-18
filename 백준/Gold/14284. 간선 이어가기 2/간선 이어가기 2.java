import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dist;
	static int D(int s, int e) {
		Queue<Line> pq = new PriorityQueue<>(
			Comparator.comparingInt(a -> a.d)
		);
		pq.add(new Line(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Line now = pq.poll();

			for (Line next : lines.get(now.s)) {
				if (dist[next.s] > dist[now.s] + next.d) {
					dist[next.s] = dist[now.s] + next.d;
					pq.add(new Line(next.s, dist[next.s]));
				}
			}
		}
		return dist[e];
	}
	static class Line {
		int s;
		int d;
		public Line(int s, int d) {
			this.s = s;
			this.d = d;
		}
	}
	static List<List<Line>> lines ;
	static int sx, ex;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		lines = new ArrayList<>();


		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i=0; i<=N; i++) {
			lines.add(new ArrayList<>());
		}
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			lines.get(s).add(new Line(e, d));
			lines.get(e).add(new Line(s, d));
		}
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		System.out.print(D(sx, ex));
	}
}
