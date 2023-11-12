import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length;
        while (n > 0) {
            Arrays.sort(works);
            int tmp = works[len-1];
            int tmp_cnt = 0;
            for (int i=len-1; i>=0; i--) {
                // 같은 최대 값을 가지면 누적 시킨다 정렬 횟수 줄이기 위해
                if (works[i] == tmp) {
                    tmp_cnt++;
                    if (tmp_cnt == n) {
                        if (works[i] >= 1) {
                            works[i] -= 1;        
                        }
                        break;
                    }
                } else {
                    break;
                }
                if (works[i] >= 1) {
                            works[i] -= 1;        
                        }
                // System.out.println(" n : "+n+" works[i] : " +works[i]);
            }
            n -= tmp_cnt;
        }
        // for (int i=0; i<len; i++) {
        //     System.out.println(works[i]);
        // }
        for (int i=0; i<len; i++) {
            
            // System.out.println(" i : "+i+ " works[i] : "+works[i]);
            answer += works[i] * works[i];
        }
        return answer;
    }
}