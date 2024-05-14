import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, X;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] prefix = new int[N + 1];
		for (int i = 0; i < N; i++) {
			prefix[i + 1] = prefix[i] + arr[i];
		}

		int ans = 0;
		int cnt = 0;
		for (int i = X; i <= N; i++) {
			int now = prefix[i] - prefix[i - X];
			if (ans < now) {
				cnt = 1;
				ans = now;
			} else if (ans == now) {
				cnt++;
			}
		}

		if (ans == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(ans);
			System.out.println(cnt);
		}

	}
}