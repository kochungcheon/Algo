import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] prefix = new int[N+1];
		for (int i=0; i<N; i++) {
			prefix[i + 1] = arr[i] + prefix[i];
		}

		long ans = 0L;
		Map<Integer, Long> map = new TreeMap<>();
		for (int i=0; i<=N; i++) {
			ans += map.getOrDefault(prefix[i] - K, 0L);
			map.put(prefix[i], map.getOrDefault(prefix[i], 0L)+1);
		}
		System.out.print(ans);
	}
}
