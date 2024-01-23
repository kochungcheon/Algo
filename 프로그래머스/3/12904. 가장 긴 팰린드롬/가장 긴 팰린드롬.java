class Solution {
    public int solution(String s) {
        for(int i = s.length(); i > 0; i--) {
            for(int j = 0; j+i <= s.length(); j++) {
                if(isPalindrome(s, j, j+i-1)) return i;
            }
        }
        return 0;
    }
    boolean isPalindrome(String value, int s, int e) {
        while(s <= e) {
            if(value.charAt(s++) != value.charAt(e--)) return false;
        }
        return true;
    }
}