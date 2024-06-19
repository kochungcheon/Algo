

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<List<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M+1];
		for (int i=0; i<N; i++) {
			adj.add(new ArrayList<>());
			List<Integer> lst = adj.get(i);
			int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j=1; j<now.length; j++) {
				arr[now[j]]++;
				lst.add(now[j]);
			}
		}

		int ans = 0;
		for (int i=0; i<N; i++) {
			if (ans == 1) break;
			List<Integer> lst = adj.get(i);
			int cnt = 0;
			for (int j=0; j<lst.size(); j++) {
				if (arr[lst.get(j)] >= 2) {
					cnt++;
				}
			}
			if (cnt == lst.size()) {
				ans = 1;
			}
		}
		System.out.print(ans);
	}

}
