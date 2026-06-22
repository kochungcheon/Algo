import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            // 
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(c);
            }
            else {
                if (stack.size() >= 1 && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        if (stack.size() > 0) return false;

        return answer;
    }
}