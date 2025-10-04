import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int len = s.length(); // 빠르게가 아니라 바르게? 
        if (len == 1) return 1;
        
        int answer = len;
        for (int k = 1; k <= len/2; k++) {
            int n = compress(s, k);
            if (n < answer) answer = n;
        }
        return answer;
    }
    public int compress(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        String prev = s.substring(0, k);
        int cnt = 1;
        for (int i=k; i<len; i+=k) {
            int end = Math.min(i+k, len);
            String curr = s.substring(i, end);
            if (prev.equals(curr)) {
                cnt++;
            } else {
                if (cnt > 1) sb.append(cnt);
                sb.append(prev);
                prev = curr;
                cnt = 1;
            }
        }
        if (cnt > 1) sb.append(cnt);
        sb.append(prev);
        return sb.length();
    }
}