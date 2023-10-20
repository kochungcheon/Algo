import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int person : people) {
            arr.add(person);
        }
        int answer = 0;
        while (arr.size() > 1){
            int fir = arr.get(0);
            int sec = arr.get(arr.size()-1);
            // System.out.println(fir + " " + sec);
            if (fir + sec <= limit){
                arr.remove(0);
            } 
            answer++;
            arr.remove(arr.size()-1);
        }
        // System.out.print(arr.toString());
        return arr.size() == 1 ? answer+1 : answer;
    }
}