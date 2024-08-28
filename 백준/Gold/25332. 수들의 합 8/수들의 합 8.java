import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] brr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] prefixA = new int[N + 1];
		int[] prefixB = new int[N + 1];
		for (int i=0; i<N; i++) {
			prefixA[i + 1] = prefixA[i] + arr[i];
			prefixB[i + 1] = prefixB[i] + brr[i];
		}

		int[] calAB = new int[N + 1];
		for (int i=1; i<=N; i++) {
			calAB[i] = prefixA[i] - prefixB[i];
		}

		long ans = 0;
		Map<Integer, Long> map = new HashMap<>();
		for (int i=0; i<=N; i++) {
			ans += map.getOrDefault(calAB[i], 0L);
			map.put(calAB[i], map.getOrDefault(calAB[i], 0L) + 1);
		}
		System.out.print(ans);
	}
}
