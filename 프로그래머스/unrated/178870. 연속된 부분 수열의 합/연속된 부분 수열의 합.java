public class Solution {

    public static void main(String[] args) throws Exception {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        Solution solution = new Solution();
        int[] answer = solution.solution(sequence, 5);
        System.out.println("--------------------------------");
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE; 

        int minStart = 0;
        int minEnd = sequence.length;

        while (start < sequence.length && end < sequence.length || sum >= k) {
            if (sum < k) {
                if (end < sequence.length) {
                    sum += sequence[end++];
                } else {
                    break;
                }
            } else {
                if (sum == k) {
                    if (end - start < minLength) {
                        minEnd = end - 1;
                        minStart = start;
                        minLength = end - start;
                    }
                }
                sum -= sequence[start++];
            }
        }
        return new int[]{minStart, minEnd};
    }
}
