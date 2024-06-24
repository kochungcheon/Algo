import java.util.*;
import java.io.*;
public class Main {
	static int N, M;
	static int[] arr;
	static class Pair {
		long time;
		int val;
		public Pair(long time, int val) {
			this.time = time;
			this.val = val;
		}
		public long getTime() {
			return time;
		}
		public int getVal() {
			return val;
		}
	}
 	public static void main(String[] args) throws IOException {
		input();
		Queue<Pair> pq = new PriorityQueue<>(
			Comparator.comparing(Pair::getTime).thenComparing(Pair::getVal)
		);
		for (int i=0; i<N; i++) {
			pq.add(new Pair(arr[i], arr[i]));
		}
		int cnt = 0;
		while (true) {
			cnt++;
			Pair now = pq.poll();
			if (cnt == M) {
				System.out.print(now.getTime());
				break;
			}
			pq.add(new Pair(now.getTime() + now.getVal(), now.getVal()));
		}
	}
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}
