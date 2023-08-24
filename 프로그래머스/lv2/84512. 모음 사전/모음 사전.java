import java.util.*;
class Solution {
    static ArrayList<String> arr = new ArrayList<>();
    static void choose(int cur, String tmp){
        if (cur > 5) return;
        arr.add(tmp);
        for (String aeiou : AEIOU){
            choose(cur + 1 , tmp + aeiou);
        }
    }
    
    static String[] AEIOU = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        choose(0, "");
        return arr.indexOf(word);
    }
}