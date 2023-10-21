import java.util.*;
class Solution {
    static boolean check(String tmp){
        // System.out.println("start : " + tmp);
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<tmp.length(); i++){
            // System.out.println(" peek : " + stack.peekLast());
            // System.out.println(stack);
            if (!stack.isEmpty() && match(stack.peekLast() , tmp.charAt(i))){
                // System.out.println(" pop : " + stack.peekLast());
                stack.pollLast();
                // System.out.println(stack);
            } else {
                stack.add(tmp.charAt(i));
                // System.out.println(" add : " + tmp.charAt(i));
                // System.out.println(stack);
            }
        }
        if (stack.isEmpty()){
            return true;
        } return false;
    }
    static boolean match(char a, char b){
        if (a == '(' && b == ')'){
            return true;
        } else if (a == '{' && b == '}'){
            return true;
        } else if (a == '[' && b == ']'){
            return true;
        } return false;
    }
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        for (int i=0; i<len; i++){
            String tmp = "";
            for (int j=0; j<len; j++){
                tmp += s.charAt((i+j) % len);
            }
            answer = check(tmp) ? answer+1 : answer;
        }
        return answer;
    }
}