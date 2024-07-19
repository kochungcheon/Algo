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
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		for (int i=0; i<B; i++) {
			arr[Integer.parseInt(br.readLine()) - 1] = 1;
		}

		int s = 0;
		int e = 0;

		int ans = Integer.MAX_VALUE;
		int tmp = arr[e] == 1 ? 1 : 0;

		while (s <= e && e < N) {
			int len = (e + 1) - s;
			if (len == K) {
				ans = Math.min(tmp, ans);
				if (arr[s++] == 1) {
					tmp--;
				}
			}
			if (arr[++e] == 1) {
				tmp++;
			}
		}
		System.out.print(ans);
	}
}