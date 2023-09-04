import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if (a == '('){
                stack.push(a);
            } else{
                if (stack.isEmpty() || stack.peek() != '('){
                    answer = false;
                } else{
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()){
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}