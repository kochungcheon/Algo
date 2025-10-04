import java.util.*;
import java.io.*;

class Solution {
    public String transform(String w) {
        if (w.isEmpty()) return "";
        int cut = firstCut(w);
        String u = w.substring(0, cut + 1);
        String v = w.substring(cut + 1);
        
        if (isValid(u)) {
            return u + transform(v);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(transform(v));
        sb.append(')');
        
        for (char c : u.substring(1, u.length() - 1).toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }
    public boolean isValid(String s) {
        int bal = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') bal++;
            else {
                bal--;
                if (bal < 0) return false;
                };
        }
        return bal == 0;
    }
    public int firstCut(String w) {
        int bal = 0;
        for (int i=0; i<w.length(); i++) {
            bal += (w.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) return i;
        }
        return 0;
    }
    public String solution(String p) {
        String answer = transform(p);
        return answer;
    }
}
// 괄호 개수는 맞지만 짝이 맞지 않는 다
// 모든 괄호 뽑아 올바른 순서로
// 