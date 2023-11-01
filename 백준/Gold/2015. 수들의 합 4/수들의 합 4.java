import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long K = sc.nextLong();
		long[] arr = new long[N+1];
		for (int i=1; i<=N; i++) {
			arr[i] = sc.nextLong();
		}
		long[] prefix = new long[N+1];
		for (int i=1; i<=N; i++) {
			prefix[i] = arr[i] + prefix[i-1];
		}

		long ans = 0;
		HashMap<Long, Long> map = new HashMap<>();

		for (int i=0; i<=N; i++) {
			ans += map.getOrDefault(prefix[i] - K, 0L);
			map.put(prefix[i], map.getOrDefault(prefix[i], 0L) + 1);
		}
		System.out.println(ans);
	}
}