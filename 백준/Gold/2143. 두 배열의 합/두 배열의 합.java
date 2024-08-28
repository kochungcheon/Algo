import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = Integer.parseInt(br.readLine());
		int[] brr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<n; i++) {
			int now = arr[i];
			map.put(now, map.getOrDefault(now, 0) + 1);
			for (int j=i+1; j<n; j++) {
				now += arr[j];
				map.put(now, map.getOrDefault(now, 0) + 1);
			}
		}

		long ans = 0L;
		for (int i=0; i<m; i++) {
			int now = brr[i];
			ans += map.getOrDefault(T - now, 0);
			for (int j=i+1; j<m; j++) {
				now += brr[j];
				ans += map.getOrDefault(T - now, 0);
			}
		}

		System.out.print(ans);
	}
}
