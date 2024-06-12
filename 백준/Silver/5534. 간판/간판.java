import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		now = br.readLine();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += check(br.readLine());
		}
		System.out.print(ans);
	}

	private static int check(String s) {
		if (s.length() < now.length())
			return 0;

		for (int i = 1; i <= 100; i++) {

			for (int j = 0; j < s.length(); j++) {
				int tmp = 0;
				int idx = j;
				int nIdx = 0;
				while (idx < s.length() && nIdx < now.length()) {
					if (s.charAt(idx) != now.charAt(nIdx)) break;
					nIdx++;
					idx += i;
					tmp++;
				}

				if (tmp == now.length()) return 1;
			}
		}
		return 0;
	}
}