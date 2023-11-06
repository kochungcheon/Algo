import java.util.*;

public class Solution {
	// vertex : 번호 weight : 가중치
	static class Pair implements Comparable<Pair> {
		int vertex;
		int weight;

		Pair(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair pair) {
			return this.weight - pair.weight;
		}
	}

	public static int[] dijkstra(Map<Integer, List<Pair>> graph, int n, int start) {
		PriorityQueue<Pair> heap = new PriorityQueue<>();
		int[] visit = new int[n + 1];
		java.util.Arrays.fill(visit, Integer.MAX_VALUE);
		heap.add(new Pair(start, 0));
		visit[start] = 0;

		while (!heap.isEmpty()) {
			Pair current = heap.poll();
			int now = current.vertex;
			int weight = current.weight;

			if (visit[now] < weight) continue;

			for (Pair pair : graph.getOrDefault(now, new ArrayList<>())) {
				if (visit[pair.vertex] > weight + pair.weight) {
					visit[pair.vertex] = weight + pair.weight;
					heap.add(new Pair(pair.vertex, visit[pair.vertex]));
				}
			}
		}

		return visit;
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		Map<Integer, List<Pair>> graph = new HashMap<>();

		for (int[] fare : fares) {
			graph.computeIfAbsent(fare[0], k -> new ArrayList<>()).add(new Pair(fare[1], fare[2]));
			graph.computeIfAbsent(fare[1], k -> new ArrayList<>()).add(new Pair(fare[0], fare[2]));
		}

		int[] distS = dijkstra(graph, n, s);
		int[] distA = dijkstra(graph, n, a);
		int[] distB = dijkstra(graph, n, b);
		for (int i = 1; i <= n; i++) {
			if (i == s) {
				answer = Math.min(answer, distA[i] + distB[i]);
			} else {
				answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
			}
		}

		return answer;
	}
}