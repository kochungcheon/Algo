class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int len = 0;

        while (sb.length() < t) {
            for (char c : Integer.toString(num, n).toCharArray()) {
                if (len++ % m == p - 1) {
                    sb.append(Character.toUpperCase(c));
                }
                if (sb.length() == t) {
                    break;   
                }
            }
            num++;
        }

        return sb.toString();
    }

}