class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i<absolutes.length; i++) {
            answer += absolutes[i] * convert(signs[i]);
        }
        return answer;
    }
    int convert(boolean sign) {
        return sign ? 1 : -1;
    }
}