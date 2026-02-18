class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int n : nums) {
            arr[n]--;
        }
        for (int i=1; i<10; i++) {
            if (arr[i] == 0) answer += i;
        }
        return answer;
    }
}