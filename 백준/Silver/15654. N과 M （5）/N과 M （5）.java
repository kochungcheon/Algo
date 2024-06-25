import java.util.*;
import java.io.*;
public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static List<Integer> chooses = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static void choose(int cur) {
		if (cur == M) {
			for (int i : chooses) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=0; i<N; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			chooses.add(arr[i]);
			choose(cur + 1);
			chooses.remove(chooses.size() - 1);
			visit[i] = false;
		}
 	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visit = new boolean[N];
		Arrays.sort(arr);
		choose(0);
		System.out.print(sb);
	}
}