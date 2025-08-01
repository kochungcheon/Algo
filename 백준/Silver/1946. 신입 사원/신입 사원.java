import java.io.*;
import java.util.*;
public class Main {
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Pair[] pairs = new Pair[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			game(N, pairs);
		}
	}

	public static void game(int N, Pair[] pairs) {
		Pair[] sorted = Arrays.stream(pairs).sorted(
			Comparator.comparingInt(Pair::getX).thenComparingInt(Pair::getY)
		).toArray(Pair[]::new);

		int ans = 1;
		int score = sorted[0].getY();

		for (int i =0; i < sorted.length; i++) {
			if (score > sorted[i].getY()) {
				ans++;
				score = sorted[i].getY();
			}
		}
		System.out.println(ans);
	}
}
