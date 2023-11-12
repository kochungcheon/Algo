import java.util.*;
class Solution {
		public int solution(int[] scoville, int K) {
			int answer = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int s : scoville) {
				pq.add(s);
			}
			while (!pq.isEmpty()) {
				int now = pq.poll();
				// 종료 조건
				if (now >= K) {
					break;
				}
				// 다음 수가 없을 때 종료
				if (pq.isEmpty()) return -1;
				int next = pq.poll();
				pq.add(now + (next * 2));
				answer++;

			}

			return answer;
		}
	}