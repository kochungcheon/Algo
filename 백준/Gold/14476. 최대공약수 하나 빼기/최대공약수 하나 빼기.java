import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int GCD(int x, int y) {
		while (y > 0) {
			int tmp = x % y;
			x = y;
			y = tmp;
		}
		return x;
	}

	static boolean isValid(int k, int candi) {
		if (k < candi) return true;
		return k % candi != 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int ans = -1;
		int[] prefixL = new int[N];

		for (int i=0; i<N; i++) {
			if (i == 0) prefixL[i] = arr[i];
			else {
				prefixL[i] = GCD(prefixL[i-1], arr[i]);
			}
		}

		int[] prefixR = new int[N];
		for (int i=N-1; i>=0; i--) {
			if (i == N-1) prefixR[i] = arr[i];
			else {
				prefixR[i] = GCD(prefixR[i + 1], arr[i]);
			}
		}

		int K = -1;

		for (int i=0; i<N; i++) {
			int candi = 0;
			if (i == 0)	candi = prefixR[i+1];
			else if (i == N - 1) candi = prefixL[i-1];
			else candi = GCD(prefixL[i-1], prefixR[i+1]);

			if (isValid(arr[i], candi)) {
				if (ans < candi) {
					K = arr[i];
					ans = candi;
				}
			}
		}

		if (ans > 0) {
			System.out.print(ans + " " + K);
		} else {
			System.out.print(-1);
		}
	}
}