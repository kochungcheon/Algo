import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int max_len = queue1.length + queue2.length;
        int try_cnt = 0;
        long queue1_sum = 0;
        long queue2_sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            queue1_sum += queue1[i];
        }
        Queue<Integer> q2 = new LinkedList<>();
        for (int i=0; i<queue2.length; i++) {
            q2.add(queue2[i]);
            queue2_sum += queue2[i];
        }
        while (max_len+10 >= try_cnt) {
            if (queue1_sum == queue2_sum) {
                return try_cnt;
            }
            try_cnt++;
            if (queue1_sum > queue2_sum){
                int now = q1.poll();
                q2.add(now);
                queue1_sum -= now;
                queue2_sum += now;
            } else {
                int now = q2.poll();
                q1.add(now);
                queue1_sum += now;
                queue2_sum -= now;
            }
        }
        
        return answer;
    }
}