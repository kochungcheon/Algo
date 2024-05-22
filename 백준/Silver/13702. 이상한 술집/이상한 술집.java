import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		for (int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		long ans = 0;
		long s = 1;
		long e = Long.MAX_VALUE;
		while (e >= s) {
			long mid = s + (e - s) / 2;
			if (check(mid)) {
				s = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				e = mid - 1;
			}
		}
		System.out.println(ans);
	}
	private static boolean check(long target) {
		int cnt = 0;
		for (long a : arr) {
			cnt += a / target;
		}
		return cnt >= M;
	}
}
