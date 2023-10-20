import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashSet<String, Integer>();
        String pre = "";
        int cnt = 0;
        for (String word : words){
            if (pre.equals("")){
                pre = word;
                map.put(word, cnt);
            } else {
                if (pre.charAt(pre.length()-1) == word.charAt(0)){
                    pre = word;
                    map.put(word, cnt);
                }
            }
            cnt++;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");

        return answer;
    }
}