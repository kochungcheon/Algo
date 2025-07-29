import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static boolean cal(int x) {
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int color = arr[i];
			while (color >= x) {
				color -= x;
				cnt++;
			}
			if (color > 0) cnt++;
		}
		return cnt <= N;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		int s = 1;
		int e = 1000_000_000;
		while (s <= e) {
			int mid =  s + (e - s) / 2;
			if (cal(mid)) {
				ans = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
