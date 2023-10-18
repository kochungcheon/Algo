import java.util.*;
import java.lang.*;
class Solution {
    
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++){
            // System.out.println(answer);
            char c = s.charAt(i);
            if (c == '('){
                stack.push(c);
            } else{
                if (stack.isEmpty() || stack.peek() == ')'){
                    answer = false;
                } else {
                     stack.pop();
                }
            }
        }
        if (!stack.isEmpty()){
                answer = false;
            }
            
        return answer;
    }
}