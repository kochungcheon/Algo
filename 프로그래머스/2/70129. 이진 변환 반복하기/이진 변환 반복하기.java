import java.util.*;

class Solution {
    static String binary(String str) {
        return Integer.toBinaryString(str.length());
    } 
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int zero = 0;
        while (!s.equals("1")) {
            cnt++;
            
            StringBuilder sb = new StringBuilder();
        
            for (Character c : s.toCharArray()) {
                if (c == '1') sb.append("1");
                else zero += 1;
            }
            
            s = binary(sb.toString());
        }
        
        return new int[]{cnt, zero};
    }
}