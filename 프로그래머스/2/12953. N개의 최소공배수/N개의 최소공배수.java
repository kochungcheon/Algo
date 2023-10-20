class Solution {
    static int gcd(int a, int b){
        if (b == 0){
            return a;
        } 
        return gcd(b, a % b);
    }
    public int solution(int[] arr) {
        int s = arr[0];
        for (int a : arr){
            s = (s * a) / gcd(s, a);
        }
        return s;
    }
}