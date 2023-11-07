import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<>();

		for (String operation : operations) {
			String[] op = operation.split(" ");
			String comand = op[0];
			String num = op[1];
			// 큐에 값을 넣는 다
			if (comand.equals("I")) {
				minPq.add(Integer.valueOf(num));
				maxPq.add(-Integer.valueOf(num));
				// 큐에 값을 뺀다 단 큐에 값이 있을 때
			} else if (comand.equals("D") && !minPq.isEmpty()) {
				// 최대 값을 뺀다
				if (num.equals("1")) {
					int maxNum = maxPq.poll();
					minPq.remove(-maxNum);
						// 최소 값을 뺀다
				} else {
					int minNum = minPq.poll();
					maxPq.remove(-minNum);
				}
			}
		}
		if (minPq.isEmpty()) {
			return new int[]{0, 0};
		}
		answer = new int[]{-maxPq.poll(), minPq.poll()};
		return answer;
    }
}