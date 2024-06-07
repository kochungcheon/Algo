import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int ans = 0;
		int s = 0;
		int e = 1000000000;
		while (e >= s) {
			int mid = (e + s) / 2;
			if (check(mid)) {
				s = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				e = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private static boolean check(int mid) {
		int cnt = 1;
		int pre = arr[0];
		for (int i=1; i<arr.length; i++) {
			if (arr[i] - pre >= mid) {
				cnt++;
				pre = arr[i];
			}
		}
		return cnt >= C;
	}
}
