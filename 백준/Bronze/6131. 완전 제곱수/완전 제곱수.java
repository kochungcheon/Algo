

import java.util.*;
import java.io.*;

public class Main {
	static List<Pair> pairs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int B=1; B<=500; B++) {
			for (int A=B; A<=500; A++) {
				if (A * A == B * B + N) {
					ans++;
				}
			}
		}
		System.out.print(ans);
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
