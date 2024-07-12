

import java.util.*;
import java.io.*;

public class Main {
	static List<Pair> pairs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		List<Integer> sumList = new ArrayList<>();
		int leftSum = 0;
		for (int i=0; i<N; i++) {
			leftSum += arr[i];
			sumList.add(leftSum);
		}

		int ans = 0;
		for (int a : sumList) {
			if (Math.abs(100 - ans) > Math.abs(100-a)) {
				ans = a;
			} else if (Math.abs(100 - ans) == Math.abs(100-a)) {
				ans = Math.max(ans, a);
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
