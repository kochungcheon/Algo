import java.io.*;
import java.util.*;
public class Main {
	static List<Integer> chooses = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[] arr;
	static int N, M;
	static void choose(int cur) {
		if (cur == M) {
			for (int i : chooses) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=0; i<N; i++) {
			chooses.add(arr[i]);
			choose(cur + 1);
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
