import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] A;
	static int find(int target) {
		int s = 0;
		int e = N-1;
		int ans = N;
		while (e >= s) {
			int mid = s + (e - s) / 2;
			if (A[mid] == target) {
				ans = Math.min(ans, mid);
				e = mid - 1;
			}
			else if (A[mid] > target) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return ans == N ? -1 : ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(A);

		for (int i=0; i<M; i++) {
			System.out.println(find(Integer.parseInt(br.readLine())));
		}
	}
}