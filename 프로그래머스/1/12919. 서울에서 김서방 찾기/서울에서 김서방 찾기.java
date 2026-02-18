class Solution {
    public String solution(String[] seoul) {
        int len = seoul.length;
        int idx = 0;
        for (int i=0; i<len; i++) {
            if (seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        }
        return String.format("김서방은 %d에 있다", idx);
    }
}