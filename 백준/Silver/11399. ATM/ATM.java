import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int ans = 0;
		int[] pre = new int[N+1];
		for (int i=0; i<N; i++) {
			pre[i+1] = pre[i] + arr[i];
		}
		for (int p : pre) {
			ans += p;
		}
		System.out.print(ans);
	}
}
