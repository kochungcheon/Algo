
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static final long MOD = 1_000_000_007L;
	static long M;
	static Map<Long, Long> memo = new HashMap<>();
	static long find(long n) {
		if (n == 0) return 1;
		if (n < 0) return 0;
		Long v = memo.get(n);
		if (v != null) return v;

		long res = (find(n - 1) + find(n - M)) % MOD;
		memo.put(n, res);
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());

		System.out.println(find(N) % MOD);
	}
}