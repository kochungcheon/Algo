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
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		int black = 0;
		int white = 0;

		int s = 0;
		int e = 0;

		int ans = 0;
		while (s <= e && e < N) {
			if (str.charAt(e) == 'W') {
				white++;
			} else {
				black++;
			}
			// 조건 만족
			if (black <= B && W <= white) {
				ans = Math.max(ans, e - s + 1);
			}

			while (black > B) {
				if (str.charAt(s) == 'W') {
					white--;
				} else {
					black--;
				}
				s++;
			}
			e++;
		}

		System.out.print(ans);
	}
}