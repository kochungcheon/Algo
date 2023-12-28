import java.util.*;
class Solution {
    static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static HashMap<Integer, Integer> map = new HashMap<>();

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	// 0 은 방문 안한 곳, 1..N 은 섬의 넘버
	static int[][] visit;
	static int n, m;
	static boolean canGo(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
	static void BFS(int x, int y, int color, String[] maps) {
		Queue<Pair> q =  new LinkedList<>();
		q.add(new Pair(x, y));
		visit[x][y] = color;
        map.put(color, map.getOrDefault(color, 0) + Integer.parseInt(String.valueOf(maps[x].charAt(y))));
		while (!q.isEmpty()) {
			Pair now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (!canGo(nx, ny)) continue;
                if (visit[nx][ny] > 0) continue;
				if (maps[nx].charAt(ny) == 'X') continue;
				visit[nx][ny] = color;
				q.add(new Pair(nx, ny));
				map.put(color, map.getOrDefault(color, 0) + Integer.parseInt(String.valueOf(maps[nx].charAt(ny))));
			}
		}
	}
	public int[] solution(String[] maps) {
		n = maps.length;
		m = maps[0].length();
		visit = new int[n][m];
		int color = 1;

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (visit[i][j] == 0 && maps[i].charAt(j) != 'X') {
					BFS(i, j, color++, maps);
				}
			}
		}
		int size = map.size();
		if (size == 0) return new int[]{-1};

		List<Integer> arr = new ArrayList<>();
		for (int i=1; i<=size; i++) {
			arr.add(map.get(i));
		}
		Collections.sort(arr);

		int[] answer = new int[size];
		for (int i=0; i<size; i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}