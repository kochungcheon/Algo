class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};
        while (n > 0) {
            int re = n % 3;
            n /= 3;
           
            if (re == 0) {
                n--;
            }
            
            answer = arr[re] + answer;
        }
        return answer;
    }
}