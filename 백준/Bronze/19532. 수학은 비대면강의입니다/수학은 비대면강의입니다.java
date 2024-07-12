
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
		for (int i=-1000; i<=1000; i++) {
			for (int j=-1000; j<=1000; j++) {
				if (arr[0] * i + arr[1] * j == arr[2] && arr[3] * i + arr[4] * j == arr[5]) {
					System.out.print(i + " " + j);
				}
			}
		}
	}
}
