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
		long M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i+1] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 1;
		long sum = arr[e];
		int ans = 0;
		while (e <= N) {
			if (sum == M) {
				ans++;
				sum += arr[++e];
				sum -= arr[s++];
			} else if (sum > M) {
				sum -= arr[s++];
				if (s > e) {
					sum += arr[++e];
				}
			} else {
				sum += arr[++e];
			}
		}
		System.out.print(ans);

	}
}