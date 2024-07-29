import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int len = str.length();

		int[] alpha = new int[26];

		int s = 0;
		int e = 0;
		int cnt = 0;
		int ans = 0;
		while (s <= e && e < len) {
			char now = str.charAt(e);
			if (++alpha[now - 'a'] == 1) cnt++;
			while (cnt > N) {
				char sNow = str.charAt(s);
				s++;
				if (--alpha[sNow-'a'] == 0) {
					cnt--;
					break;
				}
			}
			ans = Math.max(ans, e - s + 1);
			e++;
		}
		System.out.print(ans);
	}
}