import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		Arrays.fill(arr, K);

		int ans = 0;
		for (int i=1; i<=100010; i++) {
			int cnt = A;
			while (cnt > 0) {
				int min = Arrays.stream(arr).min().getAsInt();
				boolean flag = false;
				for (int j=0;j<N;j++) {
					if (arr[j] == min && cnt > 0) {
						arr[j] += B;
						cnt--;
						flag = true;
					}
				}
				if (!flag) break;
			}
			for (int j=0; j<N; j++) {
				arr[j]--;
			}
			int min = Arrays.stream(arr).min().getAsInt();
			if (min == 0) {
				ans = i;
				break;
			}

		}
		System.out.print(ans);
	}
}