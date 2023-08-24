import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands){
            int i = command[0]-1;
            int j = command[1]-1;
            int k = command[2]-1;
            int[] tmp = new int[j-i+1];
            for (int s=i; s<=j; s++){
                tmp[s-i] = array[s];  
            }
            Arrays.sort(tmp);
            System.out.print(Arrays.toString(tmp));
            answer[index] = tmp[k];
            index++;
        }
        return answer;
    }
}