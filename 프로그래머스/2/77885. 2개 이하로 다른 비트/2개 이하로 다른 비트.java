class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                long num = numbers[i];
                long mask = 1;
                while ((num & mask)!=0) {
                    mask <<= 1;
                }
                answer[i] = (mask|num) & ~(mask>>1);
            }
        }
        return answer;
    }
}
