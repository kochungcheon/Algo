import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
    
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : arr) {
            if (stack.isEmpty() || stack.peekLast() != a) {
                stack.addLast(a);
            }
        }
        
        int len = stack.size();
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            answer[i] = stack.pollFirst();
        }

        return answer;
    }
}