import java.util.*;
import java.io.*;
public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static List<Integer> chooses = new ArrayList<>();
	static void choose(int cur) {
		if (cur == M) {
			for (int i : chooses) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		int tmp = 0;
		for (int i = 0; i<N; i++) {
			if (visit[i]) continue;
			if (arr[i] == tmp) continue;
			tmp = arr[i];
			chooses.add(i);
			visit[i] = true;
			choose(cur + 1);
			visit[i] = false;
			chooses.remove(chooses.size() - 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		choose(0);
		System.out.print(sb);
	}
}