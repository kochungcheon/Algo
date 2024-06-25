import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static List<Integer> lst = new ArrayList();
	static StringBuilder sb = new StringBuilder();
	static int[] arr = new int[N];
	static void choose(int cur, int pre) {
		if (cur == M) {
			for (int i : lst) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=pre; i<N; i++) {
			lst.add(arr[i]);
			choose(cur + 1, i);
			lst.remove(lst.size()-1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		choose(0, 0);
		System.out.print(sb);
	}
}