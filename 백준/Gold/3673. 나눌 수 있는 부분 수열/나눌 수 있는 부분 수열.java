import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while (c-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] prefix = new int[n+1];
			for (int i=0; i<n; i++) {
				prefix[i + 1] = (prefix[i] + arr[i]) % d;
			}
			long ans = 0;
			Map<Integer, Long> map = new TreeMap<>();
			for (int i=0; i<=n; i++) {
				ans += map.getOrDefault(prefix[i], Long.valueOf(0));
				map.put(prefix[i], map.getOrDefault(prefix[i], Long.valueOf(0)) + 1);
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}