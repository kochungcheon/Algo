import java.util.*;
class Solution {
		public int[] solution(int[] prices) {
			int len = prices.length;

			int[] answer = new int[len];
			Deque<Pair> stack = new ArrayDeque<>();
			for (int i=0; i<len; i++) {
				Pair now = new Pair(i, prices[i]);
				if (stack.isEmpty()) {
					stack.add(now);
				} else {
					while (!stack.isEmpty()) {
						// System.out.println(stack.peekLast().value);
                        if (stack.getLast().value > now.value) {
                            
							Pair out = stack.pollLast();
							
                            answer[out.index] = now.index - out.index;
                            // System.out.println(out.index + " " + now.index);
						} else {
							// stack.add(now);
                            break;
						}

					}
                    stack.add(now);
				}
			}
            

			for (int i=0; i<len; i++) {
			// System.out.println(i + " " + answer[i]);
				if (answer[i] == 0) {
					answer[i] = len -1 - i;
				}
			}
			return answer;
		}
		static class Pair {
			int index;
			int value;

			public Pair(int index, int value) {
				this.index = index;
				this.value = value;
			}
		}
	}