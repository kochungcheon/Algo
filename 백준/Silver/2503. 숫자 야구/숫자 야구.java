

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] notCandidate = new boolean[988];
		for (int i = 123; i <= 987; i++) {
			String num = String.valueOf(i);
			if (num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)
				|| num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0') {
				notCandidate[i] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String now = st.nextToken();
			int stk = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			for (int candi = 123; candi <= 987; candi++) {
				if (notCandidate[candi]) continue;
				String cand = String.valueOf(candi);
				int nowS = 0;
				int nowB = 0;
				for (int idx = 0; idx < 3; idx++) {
					if (cand.charAt(idx) == now.charAt(idx)) {
						nowS++;
					} else if (now.contains(String.valueOf(cand.charAt(idx)))) {
						nowB++;
					}
				}
				if (nowS != stk || nowB != ball) {
					notCandidate[candi] = true;
				}
			}
		}

		int ans = 0;
		for (int i = 123; i <= 987; i++) {
			if (!notCandidate[i]) ans++;
		}
		System.out.print(ans);
	}
}
