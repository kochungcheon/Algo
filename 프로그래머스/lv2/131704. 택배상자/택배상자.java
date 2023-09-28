import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int pointer = 0;
        int cur = 1;
        Stack<Integer> belt = new Stack<>();
        while (pointer < order.length){
            if (order[pointer] > cur){
                belt.push(cur);
                cur++;
            }
            else if (order[pointer] == cur){
                answer++;
                pointer++;
                cur++;
            }
            else {
                while (!belt.isEmpty() && order[pointer] == belt.peek()){
                    belt.pop();
                    answer++;
                    pointer++;
                }
                if (pointer >= order.length || order[pointer] < cur) break;    
            }
        }
        return answer;
    }
}
