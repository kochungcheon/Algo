import java.util.*;
class Solution {
		static class Pair {
			int value;
			int index;
			private Pair(int value, int index) {
				this.value = value;
				this.index = index;
			}
			static Pair of (int value, int index) {
				return new Pair(value, index);
			}
		}
		static int[] visit;
		static Queue<Pair> q = new LinkedList<>();
		static void BFS(int x, int y, int n) {
			q.add(Pair.of(x, 0));
			while (visit[y] == 0 && !q.isEmpty()) {
				Pair now = q.poll();
				cal(now.value * 3, now.index, y);
                cal(now.value * 2, now.index, y);
                cal(now.value + n, now.index, y);
			}
		}
		static void cal(int val, int index, int m) {
			if (val <= m && 
                (visit[val] == 0 || visit[val] < index + 1)) {
				visit[val] = index + 1;
				q.add(Pair.of(val, index+1));
			}
		}
		public int solution(int x, int y, int n) {
            if (x == y) return 0;
			int answer = 0;
			// 0 초과면 가지 못한다
			visit = new int[y+1];
			BFS(x, y, n);
			answer = visit[y] > 0 ? visit[y] : -1;
			return answer;
		}
	}