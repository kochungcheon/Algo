import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int s = 0;
		int e = N - 1;
		long sum = Integer.MAX_VALUE;
		int[] ans = new int[2];
		while (s < e) {
			int now = arr[s] + arr[e];
			if (sum > Math.abs(now)) {
				ans[0] = arr[s];
				ans[1] = arr[e];
				sum = Math.abs(now);
			}
			if (now == 0) {
				s++;
				e--;
			} else if (now > 0) {
				e--;
			} else {
				s++;
			}
		}
		System.out.print(ans[0] + " " + ans[1]);
	}
}
