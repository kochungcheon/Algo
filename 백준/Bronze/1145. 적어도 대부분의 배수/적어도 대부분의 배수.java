
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
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int ans = Integer.MAX_VALUE;
		for (int num=1; num<=1000000; num++) {
			for (int i=0; i<arr.length-2; i++) {
				for (int j=i+1; j<arr.length-1; j++) {
					for (int h=j+1; h<arr.length; h++) {
						if (num % arr[i] == 0 && num % arr[j] == 0 && num % arr[h] == 0) {
							ans = Math.min(ans, num);
						}
					}
				}
			}
		}

		System.out.println(ans);

	}
}
