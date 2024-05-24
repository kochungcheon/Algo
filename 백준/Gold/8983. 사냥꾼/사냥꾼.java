import java.io.*;
import java.util.*;

public class Main {
	static int M, N, L;
	static int[] shoots;
	static List<Pair> animals = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		shoots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(shoots);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animals.add(new Pair(x, y));
		}

		int ans = 0;
		for (Pair animal : animals) {
			if (canShoot(animal)) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static boolean canShoot(Pair animal) {
		int start = 0, end = shoots.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int dist = Math.abs(shoots[mid] - animal.x) + animal.y;
			if (dist <= L) {
				return true;
			} else if (shoots[mid] < animal.x) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}