import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> stack = new ArrayList<Integer>();
        stack.add(arr[0]);
        for (int a : arr){
            if (stack.get(stack.size()-1) == a) continue;
            stack.add(a);
        }
        int[] answer = new int[stack.size()];
        for (int i=0; i<stack.size(); i++){
            answer[i] = stack.get(i);
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}