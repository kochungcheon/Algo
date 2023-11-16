
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 1; 
        for (int A : stations) {
            int count = 0;
            if (A - left >= w + 1) { 
                count += (A - left - w) / (w * 2 + 1);
                if ((A - left - w) % (w * 2 + 1) != 0) count++;
            }
            answer += count;
            left = A + w + 1;
        }
        if (left <= n) { // stations마지막에서 n 까지 전파가 닿는지 안닿는지 체크
            int count = 0;
            count += (n - stations[stations.length - 1] - w) / (w * 2 + 1);
            if ((n - stations[stations.length - 1] - w) % (w * 2 + 1) != 0) count++;
            answer += count;
        }
        return answer;
    }
}