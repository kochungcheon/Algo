

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static void DFS(int x) {
		for (Integer i : list.get(x)) {
			if (visited[i]) continue;
			visited[i] = true;
			DFS(i);
		}
	}
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M =  Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		StringTokenizer st;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		DFS(1);
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) ans++;
		}
		System.out.println(ans == 0 ? 0 : ans - 1);
	}
}
