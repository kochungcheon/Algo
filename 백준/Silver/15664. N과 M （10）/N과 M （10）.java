import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static List<Integer> chooses = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		visit = new boolean[N];
		choose(0, 0);
		System.out.print(sb);
	}

	private static void choose(int cur, int pre) {
		if (cur == M) {
			for (int i : chooses) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		int tmp = 0;
		for (int i = pre; i < N; i++) {
			if (visit[i])
				continue;
			if (arr[i] == tmp)
				continue;
			tmp = arr[i];
			visit[i] = true;
			chooses.add(arr[i]);
			choose(cur + 1, i + 1);
			chooses.remove(chooses.size() - 1);
			visit[i] = false;
		}
	}
}