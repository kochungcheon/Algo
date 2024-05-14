import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long A, B;
	static int max = 10000000;
	static boolean[] prime = new boolean[max + 1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i=2; i*i<=max; i++) {
			for (int j=i*i; j<=max; j+=i) {
				prime[j] = false;
			}
		}

		long ans = 0;
		for (int i=2; i<=max; i++) {
			if (prime[i]) {
				long compare = i * (long) i;
				while (B >= compare) {
					if (compare >= A) {
						ans++;
					}
					if (compare > Long.MAX_VALUE / i) break;
					compare *= i;
				}
			}
		}

		System.out.println(ans);
	}
}
