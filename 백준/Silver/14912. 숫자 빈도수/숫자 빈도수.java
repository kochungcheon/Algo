import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, d;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		int ans = 0;
		for (int i=1; i<=N; i++) {
			ans += check(i);
		}
		System.out.println(ans);
	}

	private static int check(int target) {
		int temp = 0;
		while (target > 0) {
			int n = target % 10;
			if (d == n) {
				temp++;
			}
			target /= 10;
		}
		return temp;
	}
}