import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] ans = new int[51];
		for (int a : arr) {
			ans[a]++;
		}
		for (int i=1; i<=N; i++) {
			if (ans[i] >= 2 && i + K <= N) {
				while (ans[i] > 1) {
					ans[i]--;
					ans[i+K]++;
				}
			}
		}
		boolean flag = true;
		for (int i=1; i<=N; i++) {
			if (ans[i] < 1) {
				flag = false;
				break;
			}
		}
		System.out.print(flag ? 1 : 0);
	}
}
