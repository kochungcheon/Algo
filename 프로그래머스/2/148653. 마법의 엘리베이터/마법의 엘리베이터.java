class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            int less = storey % 10;
            storey /= 10;
            if (less > 5) {
                storey++;
                answer += 10 - less;
            } 
            else if (less == 5) {
                if (storey % 10 >= 5) {
                    answer += 10 - less;
                    storey++;
                }
                else {
                    answer += less;
                }
            }
            else {
                answer += less;
            }
        }
        return answer;
    }
}