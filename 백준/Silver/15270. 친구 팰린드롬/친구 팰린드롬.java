import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		friends = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			friends[i][0] = Integer.parseInt(st.nextToken());
			friends[i][1] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		visit = new boolean[N + 1];

		find(0, 0);

		ans *=2;

		if (ans < N) {
			ans++;
		}

		System.out.println(ans);

	}

	static int N, M, ans;
	static int[][] friends;
	static boolean[] visit;

	static void find(int index, int count) {

		if (index >= M) {
			ans = Math.max(ans, count);
			return;
		}

		if (visit[friends[index][0]] || visit[friends[index][1]]) {
			find(index + 1, count);
		} 
		
		else {
			visit[friends[index][0]] = true;
			visit[friends[index][1]] = true;

			find(index + 1, count + 1);

			visit[friends[index][0]] = false;
			visit[friends[index][1]] = false;

			find(index + 1, count);
		}

	}
}