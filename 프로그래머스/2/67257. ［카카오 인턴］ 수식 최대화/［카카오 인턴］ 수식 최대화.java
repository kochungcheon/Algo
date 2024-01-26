import java.util.*;
class Solution {
    static String[] opers = {"+-*", "+*-", "*+-", "*-+", "-+*", "-*+"};
    public long solution(String expression) {
        List<String> arr = new ArrayList<>();
        String t = "";
        for (int i=0; i<expression.length(); i++) {
            Character c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                arr.add(t);
                t = "";
                arr.add(String.valueOf(c));
            } else {
                t += c;
            }
        }
        arr.add(t);
        
        long answer = 0;
        for (String oper : opers) {
            ArrayList<String> tmp = new ArrayList<>(arr);
            for (int i=0; i<3; i++) {
                String now = String.valueOf(oper.charAt(i));
                for (int j=1; j<tmp.size(); j+=2) {
                    String com = tmp.get(j);
                    
                    if (!now.equals(com)) continue;
                    
                    long s = Long.parseLong(tmp.get(j-1));
                    long e = Long.parseLong(tmp.get(j+1));
                    long res = 0;
                    
                    if (com.equals("+")) {
                        res = s + e;
                    }
                    else if (com.equals("-")) {
                        res = s - e;
                    }
                    else if (com.equals("*")) {
                        res = s * e;
                    }
                    tmp.set(j-1, String.valueOf(res));
                    tmp.remove(j);
                    tmp.remove(j);
                    j = j - 2;
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(tmp.get(0))));
        }
        
        return answer;
    }
}
