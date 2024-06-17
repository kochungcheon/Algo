import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;
	static boolean check(int target) {
		long tmp = 0;
		for (int a : arr) {
			if (a < target) {
				tmp += target - a;
				if (tmp > K) return false;
			}
		}
		return tmp <= K;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int s = 1;
		int e = 2_000_000_000;
		int ans = 0;
		while (e >= s) {
			int mid = s + (e - s) / 2;
			if (check(mid)) {
				s = mid + 1;
				ans = Math.max(mid, ans);
			} else {
				e = mid - 1;
			}
		}
		System.out.print(ans);
	}
}