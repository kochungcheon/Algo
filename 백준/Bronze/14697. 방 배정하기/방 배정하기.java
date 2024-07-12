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

		boolean flag = false;
		for (int i=0; i<=300; i++) {
			for (int j=0; j<=150; j++) {
				for (int h=0; h<=150; h++) {
					if (arr[0] * i + arr[1] * j + arr[2] * h == arr[3]) {
						flag = true;
						break;
					} else if (arr[0] * i + arr[1] * j + arr[2] * h > arr[3]) {
						break;
					}
				}
				if (flag) break;
			}
			if (flag) break;
		}

		System.out.print(flag ?  1 : 0);
	}
}
