import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] pre = new int[N+1];

		for (int i=0; i<N; i++) {
			pre[i+1] = pre[i] + arr[i];
		}

		int ans = Integer.MIN_VALUE;
		for (int i=M; i<=N; i++) {
			ans = Math.max(ans, pre[i] - pre[i-M]);
		}
		System.out.print(ans);

	}
}