import java.util.*;
class Solution {
    Integer convert(String time) {
        String[] time_slice = time.split(":");
        Integer h = Integer.valueOf(time_slice[0]) * 60;
        Integer m = Integer.valueOf(time_slice[1]);
        return h + m;
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time_table = new int[1500];
        for (String[] book : book_time) {
            Integer s = convert(book[0]);
            Integer e = convert(book[1]) + 10;
            for (int i=s; i<e; i++) {
                time_table[i]++;
                answer = Math.max(answer, time_table[i]);
            }
        }
        
        return answer;
    }
}