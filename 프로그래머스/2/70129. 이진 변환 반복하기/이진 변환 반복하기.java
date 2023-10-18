import java.util.*;
import java.lang.*;

class Solution {
    static String binary(String a){
        return Integer.toBinaryString(a.length());
    }
    public int[] solution(String s) {
        int oper = 0;
        int zeroCnt = 0;
        
        while (!s.equals("1")){
            oper++;
            

            StringBuilder tmp = new StringBuilder();
            for (int i=0; i<s.length(); i++){
                if ('0' == s.charAt(i)){
                    zeroCnt++;
                } else {
                    tmp.append('1');
                }
            }    
            s = binary(tmp.toString());
        }
        
        int[] answer = new int[2];
        answer[0] = oper;
        answer[1] = zeroCnt;
        
        return answer;
    }
}