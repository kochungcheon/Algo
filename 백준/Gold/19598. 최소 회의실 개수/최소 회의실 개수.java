import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static class Pair {
		int time;
		int val;
		public Pair(int time, int val) {
			this.time = time;
			this.val = val;
		}
		public int getTime() {
			return time;
		}
		public int getVal() {
			return val;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Pair> pq = new PriorityQueue<>(
			Comparator.comparing(Pair::getTime).thenComparing(Pair::getVal)
		);
		StringTokenizer st;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new Pair(s, 1));
			pq.add(new Pair(e, -1));
		}
		int ans = 0;
		int tmp = 0;
		while(!pq.isEmpty()) {
			Pair now = pq.poll();
			tmp += now.getVal();
			ans = Math.max(ans, tmp);
		}
		System.out.print(ans);
	}
}
