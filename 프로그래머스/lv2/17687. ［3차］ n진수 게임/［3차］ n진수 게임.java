class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = ""; 
        String your = "";
        for (int i = 0; i <= t * m; i++) {
            your += convert(i, n);
        }
        for (int i = 0; i < t; i++) {
            answer += your.charAt(p - 1 + i * m);
        }

        return answer;
    }
    static final char[] arr = "0123456789ABCDEF".toCharArray();
    static String convert(int n, int k){
        if(n< k){
            return Character.toString(arr[n]);
        } return convert(n/k, k) + arr[n % k];
    }
}