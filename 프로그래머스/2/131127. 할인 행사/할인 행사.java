import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = discount.length;
        
        for (int i=0; i<len-10 + 1; i++){
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int j=i; j<i+10; j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
            
            int tmp_cnt = 0;
            for (int k = 0; k < number.length; k++){
                String w = want[k];
                int n = number[k];
                if (n == map.getOrDefault(w, 0)){
                    tmp_cnt++;
                }
            if (tmp_cnt == number.length){
                answer++;
                }
            }
        }
        return answer;
    }
}