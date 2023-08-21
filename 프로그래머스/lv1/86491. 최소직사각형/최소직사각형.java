import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int s = 0;
        int l = 0;
        for (int i=0; i<sizes.length; i++){
            l = Math.max(l, Math.max(sizes[i][0], sizes[i][1]));
            s = Math.max(s, Math.min(sizes[i][0], sizes[i][1]));
        }
        answer = l * s;
        return answer;
    }
}