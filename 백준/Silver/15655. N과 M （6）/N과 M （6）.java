import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static List<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		choose(0, 0);
		
	}

	private static void choose(int cur, int pre) {
		if (cur == M) {
			for (int i=0; i<M-1; i++) {
				System.out.print(ans.get(i) + " ");
			}
			System.out.println(ans.get(M-1));
			return;
		}

		for (int i=pre; i<N; i++) {
			ans.add(arr[i]);
			choose(cur + 1, i + 1);
			ans.remove(ans.size() - 1);
		}
	}
}