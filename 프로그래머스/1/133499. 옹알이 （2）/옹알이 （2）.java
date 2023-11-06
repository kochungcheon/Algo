import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] bab_list = {"aya", "ye", "woo", "ma"};
        for (String bab : babbling) {
            int cnt = 0;
            while (cnt < bab.length()){
                cnt++;
                for (String remove : bab_list) {
                    if (bab.contains(remove) && !bab.contains(remove + remove)){
                        bab = bab.replaceAll(remove, " ");
                    }
                }
            }
            if (bab.trim().length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}