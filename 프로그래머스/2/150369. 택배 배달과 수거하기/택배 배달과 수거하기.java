class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int de_cnt = 0;
        int pick_cnt = 0;
        for (int i=n-1; i>=0; i--) {
            de_cnt += deliveries[i];
            pick_cnt += pickups[i];
            while (de_cnt > 0 || pick_cnt > 0) {
                de_cnt -= cap;
                pick_cnt -= cap;
                answer += (i+1) * 2;
            }
            
        }
        
        return answer;
    }
}