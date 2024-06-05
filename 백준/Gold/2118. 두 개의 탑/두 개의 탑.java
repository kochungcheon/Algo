import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max += arr[i];
		}

		int[] prefix = new int[N + 1];
		for (int i = 0; i < N; i++) {
			prefix[i + 1] = prefix[i] + arr[i];
		}
		int ans = 0;

		int s = 0;
		int e = 1;
		while (e >= s && e <= N) {
			int now = prefix[e] - prefix[s];
			ans = Math.max(ans, Math.min(max - now, now));
			if (now * 2 >= max) {
				s++;
			} else {
				e++;
			}
		}

		System.out.println(ans);
	}
}