import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static long[][] ing; // 신 쓴
	static long ans = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		ing = new long[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ing[i][0] = Long.parseLong(st.nextToken());
			ing[i][1] = Long.parseLong(st.nextToken());
		}

		recur(0, 1, 0, 0);

		System.out.println(ans);
	}

	private static void recur(int idx, long sour, long bitter, int cnt) {
		if (idx == n) {
			if (cnt == 0) return;
			ans = Math.min(ans, Math.abs(sour - bitter));
			return;
		}

		recur(idx + 1,
			sour * ing[idx][0],
			bitter + ing[idx][1],
			cnt + 1);

		recur(idx + 1, sour, bitter, cnt);
	}
}

