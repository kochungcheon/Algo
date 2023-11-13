import java.util.*;
class Solution {
		static class Pair {
			int index;
			int value;
			public Pair(int index, int value) {
				this.index = index;
				this.value = value;
			}
		}
		public int[] solution(int[] numbers) {
			int len = numbers.length;
			Deque<Pair> stack = new ArrayDeque<>();
			int[] answer = new int[len];
			for (int i=0; i<len; i++) {
				int now = numbers[i];
				if (stack.isEmpty()) {
					stack.add(new Pair(i, now));
				} else {
					while (!stack.isEmpty()) {
                        if (stack.getLast().value < now) {
                            Pair tmp = stack.pollLast();
							answer[tmp.index] = now;
                            if (stack.isEmpty()) {
                                stack.add(new Pair(i, now));
							    break;
                            }
                        }
						else {
							stack.add(new Pair(i, now));
							break;
						}
					}
                    
				}
			}
			for (int i=0; i<len; i++) {
				if (answer[i] == 0) {
					answer[i] = -1;
				}
			}
			return answer;
		}
	}