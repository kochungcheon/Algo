import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] digit = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(digit);
        for (int i = digit.length - 1; i >= 0; i--) {
            sb.append(digit[i]);
        }
        
        
        return Long.parseLong(sb.toString());
    }
}