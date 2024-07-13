import java.util.*;
import java.io.*;

public class Main {
	static List<Pair> pairs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pairs = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			pairs.add(new Pair(s, e)); // 가로 세로 각각 10
		}

		// 모든 점이 색종이 내에 있는 지 확인
		int ans = 0;
		for (int x=0; x<= 100; x++) {
			for (int y=0; y<=100; y++) {
				if (check(x, y)) {
					ans++;
				}
			}
		}

		System.out.print(ans);
	}
	static boolean check(int x, int y) {
		for (Pair now : pairs) {
			if (now.x <= x && x < now.x + 10 && now.y <= y && y < now.y + 10) {
				return true;
			}
		}
		return false;
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}