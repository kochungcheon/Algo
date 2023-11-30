class Solution {
    static Integer ha(int x) {
        int temp = 0;
        while (x > 0) {
            temp += x % 10;
            x /= 10;
        }
        return temp;
    }
    public boolean solution(int x) {
        boolean answer = true;
        if (x % ha(x) != 0) {
            answer = false;
        } 
        return answer;
    }
}