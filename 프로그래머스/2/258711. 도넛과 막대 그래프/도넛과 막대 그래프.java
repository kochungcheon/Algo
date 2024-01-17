import java.util.*;
class Solution {
	public int[] solution(int[][] edges) {
		// 범인, 도넛, 막대, 8자
		int[] answer = new int[4];
		int len = 1000001;
		int[] arr = new int[len];
		ArrayList<Integer>[] adj = new ArrayList[len];
		for (int i=0; i<len; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {

			arr[edge[0]]--;
			arr[edge[1]]++;

			adj[edge[0]].add(edge[1]);
		}
		int en = -1;
		for (int i=0; i<len; i++) {
			if (arr[i]<-1) {
				en = i;
			}
		}
		answer[0] = en;
		ArrayList<Integer> rootNode = new ArrayList<>();
		// root 노드에 값 넣기
		for (int[] edge : edges) {
			if (edge[0] == edge[1]) continue;
			if (edge[0] == en) {
				rootNode.add(edge[1]);
			}
		}
		// 방문 안한거면 노드 개수 늘리고 한거면 넘어가~
		boolean[] visit = new boolean[len];
		for (int root : rootNode) {
			// 아무것도 연결 되어 있찌 않으면 직선 노드 취급
			if (adj[root].size() == 0) {
				answer[2]++;
				continue;
			}
			if (!visit[root]) {
				Queue<Integer> queue = new ArrayDeque<>();
				queue.add(root);
				visit[root]=true;
				int nodeCnt = 1;
				int vertexCnt = 0;

				while (!queue.isEmpty()) {
					int now = queue.poll();

					for (int node : adj[now]) {
						vertexCnt++;
						if (!visit[node]) {
							nodeCnt++;
							queue.add(node);
							visit[node] = true;
						}
					}
				}

				// 도넛인 경우
				if (nodeCnt == vertexCnt) {
					answer[1]++;
				}
				// 막대인 경우
				else if (nodeCnt > vertexCnt) {
					answer[2]++;
				}
				// 팔자인 경우
				else if (vertexCnt > nodeCnt) {
					answer[3]++;
				}
				// System.out.println(root + " " + nodeCnt + " " + vertexCnt);

			}
			// 0 범인, 1 도넛, 2 막대, 3 8자
		}
		return answer;
	}
}