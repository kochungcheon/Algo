import java.util.*;
class Solution {
		public int solution(int[] topping) {
			int answer = 0;
			HashMap<Integer, Integer> A = new HashMap<>();
			HashMap<Integer, Integer> B = new HashMap<>();
			// 초기 값 
			for (int t : topping) {
				A.put(t, A.getOrDefault(t, 0)+1);
			}
			int total = A.size();
			// B 에 하나씩 할당
			// A 도 하나씩 빼준다
			// A 가 0 이 되면 없애준다 그리고 사이즈도 1 줄인 다 
			// A 와 B 의 사이즈가 같으면 answer ++ 를 해준다 
			// 마지막 까지 확인하면 될 듯
			boolean flag = false;
			for (int t : topping) {
				B.put(t, B.getOrDefault(t, 0)+1);
				A.put(t, A.get(t)-1);
				if (A.get(t) == 0) {
					A.remove(t);
				}
				if (B.size() == A.size()) {
					answer++;
				} else if (flag) {
					break;
				}
			}
			
			return answer;
		}
	}