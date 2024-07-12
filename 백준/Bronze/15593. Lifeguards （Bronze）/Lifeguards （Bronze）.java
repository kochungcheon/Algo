import java.util.*;
import java.io.*;

public class Main {
	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<Pair> pairs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pairs = new ArrayList<>();
		StringTokenizer st;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pairs.add(new Pair(s, e-1));
		}

		int ans = 0;

		// 제외
		for (int i=0; i<N; i++) {
			boolean[] coverTime = new boolean[1001];
			for (int j=0; j<N; j++) {
				if (i == j) continue;
				Pair pair = pairs.get(j);
				for (int h= pair.x; h <= pair.y; h++) {
					coverTime[h] = true;
				}
			}
			int tmp = 0;
			for (int j=0; j<=1000; j++) {
				if (coverTime[j]) tmp++;
			}
			ans = Math.max(ans, tmp);
		}

		System.out.println(ans);
	}
}