import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        
 
        int compare = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        int index = 0;
        
        for (int i = 1; i < N; i++) {

            int days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            
            if (compare >= days) {
                arr.set(index, arr.get(index) + 1);
            } else {
                arr.add(1);
                index++;
                compare = days;
            }
        }
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}
