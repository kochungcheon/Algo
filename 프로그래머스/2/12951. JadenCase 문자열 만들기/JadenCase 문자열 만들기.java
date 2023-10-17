import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] s_arr = s.toLowerCase().split("");
        System.out.println(Arrays.toString(s_arr));
        boolean flag = true;
        for (String s_val : s_arr){
            answer += flag ? s_val.toUpperCase() : s_val;
            System.out.println(s_val.toUpperCase());
            flag = s_val.equals(" ") ? true : false;
        }
        return answer;
    }
}