import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> map = new HashSet<String>();
        String pre = "";
        int cnt = 0;
        for (String word : words){
            // 시작
            cnt++;
            if (pre.equals("")){
                pre = word;
                map.add(word);
            } else {
                // 끝말잇기가 가능 한지 체크
                if (pre.charAt(pre.length()-1) != word.charAt(0) || map.contains(word)){
                    System.out.println(cnt + " " + n);
                    answer[0] = (cnt % n) == 0 ? n : cnt % n;
                    answer[1] = (cnt % n) == 0 ? cnt / n : cnt / n + 1;
                    break;
                }
                pre = word;
                map.add(word);
            }
        }
        
        
        return answer;
    }
}