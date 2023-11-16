import java.util.*;
class Solution {
	public int solution(int[][] routes) {
		int len = routes.length;
		Arrays.sort(routes, (a, b) -> {
			if (a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			} else {
				return Integer.compare(a[1], b[1]);
			}
		});
		int answer = 0;
		boolean[] visit = new boolean[len];
		for (int i=0; i<len; i++) {
			if (visit[i]) continue;
			answer++;
			visit[i] = true;
			for (int j=0; j<len; j++) {
				if (visit[j]) continue;
				if (routes[i][1] >= routes[j][0] && routes[j][1] >= routes[i][1]) {
					visit[j] = true;
				}
			}
		}
		
		return answer;
	}
}