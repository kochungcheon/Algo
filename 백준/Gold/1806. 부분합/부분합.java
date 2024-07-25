import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int ans = Integer.MAX_VALUE;
		int s = 0;
		int e = 0;
		int tmp = 0;
		while (e >= s && N > e) {
			tmp += arr[e];

			while (tmp >= S) {
				ans = Math.min(ans, e - s + 1);
				tmp -= arr[s++];
			}
			e++;
		}
		System.out.print(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}