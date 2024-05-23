import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		long ans = 0;
		for (int i=0; i<N-1; i++) {
			ans += checkMax(i);
		}
		System.out.println(ans);
	}
	private static int checkMax(int idx) {
		int s = idx + 1;
		int e = N - 1;
		int cnt = idx;
		while (e >= s) {
			int mid = (s + e) / 2;
			if (arr[mid] * 9 <= arr[idx] * 10) {
				cnt = Math.max(cnt, mid);
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return cnt - idx;
	}
}