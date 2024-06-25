import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = new int[]{4, 2, 3, 3, 3, 3, 3, 3, 3, 3};

		while(true) {
			int now = Integer.parseInt(br.readLine());
			int ans = 1;
			if (now == 0) break;
			while (now > 0) {
				int n = now % 10;
				ans += cnt[n] + 1;
				now /= 10;
			}
			System.out.println(ans);
		}
	}
}
