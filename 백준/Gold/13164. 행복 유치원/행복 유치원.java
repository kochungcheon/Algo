import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] cal = new int[N-1];
		for (int i = 0; i < N - 1; i++) {
			cal[i] = arr[i + 1] - arr[i];
		}
		Arrays.sort(cal);
		int ans = 0;
		for (int i = 0; i < N - K; i++) {
			ans += cal[i];
		}
		System.out.println(ans);
	}
}