import java.util.*;
class Solution {
    public String solution(String s) {
        String[] s_arr = s.split(" ");
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        for (String s_v : s_arr){
            Integer i_v = Integer.parseInt(s_v);
            min_value = Math.min(min_value, i_v);
            max_value = Math.max(max_value, i_v);
        }
        System.out.println(Arrays.toString(s_arr));
        String answer = min_value + " " + max_value;
        return answer;
    }
}