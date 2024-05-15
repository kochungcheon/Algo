import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			int ans = Integer.MIN_VALUE;
			int a = 0;
			for (int i=0; i<N; i++) {
				int n = Integer.parseInt(br.readLine());
				a = Math.max(n, a + n);
				ans = Math.max(a, ans);
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}