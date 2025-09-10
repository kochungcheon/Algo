import java.util.*;
import java.io.*;

// 65 ~ 90
// 1 ~ 26
class Solution {
    public int[] solution(String msg) {
        int len = msg.length();

        List<Integer> lst = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), c - 'A' + 1);
        }
        int nextIdx = 27;

        for (int i = 0; i < len; i++) {
            System.out.println(i);
            int index = i + 1;

            while (index < len && dict.containsKey(msg.substring(i, index + 1))) {
                index++;
            }

            String w = msg.substring(i, index);
            lst.add(dict.get(w));
            
            if (index < len) {
                String str = msg.substring(i, index + 1);
                if (!dict.containsKey(str)) {
                    dict.put(str, nextIdx++);
                }
            }
            
            i = index - 1;
        }

        int[] answer = new int[lst.size()];
        for (int k = 0; k < lst.size(); k++) answer[k] = lst.get(k);
        return answer;
    }
}
