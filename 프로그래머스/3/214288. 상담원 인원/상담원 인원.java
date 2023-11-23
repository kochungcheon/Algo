import java.util.*;
class Solution {
    static class Pair {
		int num, time;
		public Pair(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	public static int solution(int k, int n, int[][] reqs) {
		int answer = 0;
		int[] people = new int[k+1];
		Arrays.fill(people, 1);
		PriorityQueue<Pair>[] peopleList = new PriorityQueue[k+1];
		Comparator<Pair> pairComparator = Comparator.comparingInt(p -> p.time);
		for (int i=1; i<k+1; i++) {
			peopleList[i] = new PriorityQueue<>(pairComparator);
			peopleList[i].add(new Pair(i, 0));
		}
		// 최소 한명은 있어야 한다. index 0은 무시하자

		int nk = n - k;

		// 컨설턴트를 배정 하는 식
		// 가장 기다린 시간이 많은 친구에게 1 더 배정한다
		while (nk > 0) {
			int minTime = Integer.MAX_VALUE;
			int min_index = -1;
			// 하나씩 넣어서 최적을 찾는 다
			for (int i=1; i<k+1; i++) {
				peopleList[i].add(new Pair(i, 0));
				int nowTime = 0;

				for (int[] req : reqs) {
					int req_num = req[2];
					int req_start = req[0];
					int req_working = req[1];
					Pair now = peopleList[req_num].poll();
					if (now.time > req_start) {
						// 이번 분기 기다린 시간을 더한다
						nowTime += now.time - req_start;
						peopleList[req_num].add(new Pair(req_num, now.time+req_working));
					} else {
						peopleList[req_num].add(new Pair(req_num, req_start+req_working));
					}
				}

				// 최소 시간 가지는 것에 직원을 배치한다
				if (nowTime < minTime) {
					min_index = i;
					minTime = nowTime;
				}
				peopleList[i].poll();

				for (int j = 1; j < k + 1; j++) {
					peopleList[j].clear();  
					for (int h=0; h<people[j]; h++) {
						peopleList[j].add(new Pair(j, 0));
					}
				}
			}
			peopleList[min_index].add(new Pair(min_index, 0));
			people[min_index]++;
			nk--;
			if (nk == 0) {
				return minTime;
			}
		}

		// 만약 직원 수랑 번호 수가 같으면

		for (int[] req : reqs) {
			int req_num = req[2];
			int req_start = req[0];
			int req_working = req[1];
			Pair now = peopleList[req_num].poll();
			if (now.time > req_start) {
				answer += now.time - req_start;
				peopleList[req_num].add(new Pair(req_num, now.time+req_working));
			} else {
				peopleList[req_num].add(new Pair(req_num, req_start+req_working));
			}
		}

		return answer;
	}
}