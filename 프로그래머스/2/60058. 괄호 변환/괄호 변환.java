import java.util.*;	
class Solution {
		static int index;
		static boolean check(String p) {
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			int open = 0;
			int close = 0;
			for (int i=0; i<p.length(); i++) {
				if (p.charAt(i) == '(') {
					open++;
					stack.push('(');
				} else {
					close++;
					if (stack.isEmpty()) {
						flag = false;
					} else {
						stack.pop();
					}
				}
				if (open == close) {
					index = i + 1;
					return flag;
				}
			}
			return true;
		}
		public String solution(String p) {
			if (p.isEmpty()) {
				return p;
			}

			boolean flag = check(p);
			String u = p.substring(0, index);
			String v = p.substring(index);
			// 3
			if (flag) {
				return u + solution(v);
				// 4
			} else {
				String answer = "(";
				
				answer += solution(v);
				
				answer += ')';
				
				for (int i=1; i<u.length()-1; i++) {
					if (u.charAt(i) == '(') {
						answer += ")";
					} else {
						answer += "(";
					}
				}
				return answer;
			}
		}
	}