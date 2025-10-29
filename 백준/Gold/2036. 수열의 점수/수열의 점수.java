
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int ones = 0;
		int zeros = 0;
		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(br.readLine());
			arr[i] = v;
			if (v == 1) ones++;
			else if (v == 0) zeros++;
		}

		Arrays.sort(arr);

		long ans = 0;

		int l = 0;
		while (l + 1 < N && arr[l] < 0 && arr[l + 1] < 0) {
			ans += (long) arr[l] * arr[l + 1];
			l += 2;
		}
		if (l < N && arr[l] < 0) {
			if (zeros <= 0) {
				ans += arr[l];
			}
		}

		int r = N - 1;
		while (r >= 0 && arr[r] > 1) {
			if (r - 1 >= 0 && arr[r - 1] > 1) {
				ans += (long) arr[r] * arr[r - 1];
				r -= 2;
			} else {
				ans += arr[r];
				r--;
			}
		}

		ans += ones;

		System.out.println(ans);
	}
}
