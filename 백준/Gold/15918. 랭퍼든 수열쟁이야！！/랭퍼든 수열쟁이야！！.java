import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, X, Y, ans;
	static int[] arr, visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		ans = 0;

		arr = new int[25];
		visit = new int[N+1];

		arr[X] = arr[Y] = Y - X - 1;
		visit[Y-X-1] = 1;
		check(1);
		System.out.println(ans);
	}

	private static void check(int cur) {
		if (cur == N*2) {
			ans++;
			return;
		}
		if (arr[cur] != 0) {
			check(cur + 1);
			return;
		}

		for (int i=1; i<=N; i++) {
			if (visit[i] == 1) continue;
			if (cur + i + 1 <= 2*N && arr[cur + i + 1] == 0) {
				arr[cur] = arr[cur + i + 1] = i;
				visit[i] = 1;
				check(cur + 1);
				arr[cur] = arr[cur + i + 1] = visit[i] = 0;
			}
		}
	}
}