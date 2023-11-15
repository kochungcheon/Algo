import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int A_len = A.length;
        int B_len = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0;
        int b = 0;
        while (a < A_len && b < B_len) {
            if (A[a] < B[b]) {
                answer++;
                a++;
                b++;
            } else {
                b++;
            }
        }
        return answer;
    }
}