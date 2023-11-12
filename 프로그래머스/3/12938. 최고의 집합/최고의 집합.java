import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int index = 0;
        int[] answer = new int[n];
        while (n > 0) {
            if (n == 1) {
                answer[index] = s;
                break;
            }
            int tmp = s/n;
            if (s%n > 0) {
                tmp++;
            }
            s -= tmp;
            n--;
            answer[index++] = tmp; 
        }
        Arrays.sort(answer);
        return answer;
    }
}