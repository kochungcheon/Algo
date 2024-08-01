import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long X = Long.parseLong(st.nextToken());

		long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		Arrays.sort(arr);



		int ans = 0;
		int s = 0;
		int e;
		int lest = N;
		for (e = N - 1; e >= 0; e--) {
			if (arr[e] < X) break;
			ans++; lest--;
		}

		while (e > s) {
			if (arr[e] + arr[s++] + X / 2 >= X) {
				e--;
				ans++;
				lest -= 2;
			}
		}
		ans += lest / 3;

		System.out.print(ans);
	}
}