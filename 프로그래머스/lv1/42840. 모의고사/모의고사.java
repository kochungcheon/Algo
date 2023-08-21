import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] tmp = {0, 0, 0};
        int[] one = {1,2,3,4,5}; // 5
        int[] two = {2,1,2,3,2,4,2,5}; // 8
        int[] three = {3,3,1,1,2,2,4,4,5,5}; // 10
        for (int i=0; i<answers.length; i++){
            int com = answers[i];
            if (com == one[i%5]){
               tmp[0]++; 
            }
            if (com == two[i%8]){
                tmp[1]++;
            }
            if (com == three[i%10]){
                tmp[2]++;
            }
        }
        int value = Math.max(tmp[0], Math.max(tmp[1], tmp[2]));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=0; i<3; i++) if (value == tmp[i]) arr.add(i+1);
        
        int[] answer = new int[arr.size()];
        for (int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}