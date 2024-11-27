import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String[] slt = s.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (String ss : slt) {
            Integer a = Integer.parseInt(ss);
            arr.add(a);
        }
        Collections.sort(arr);
        String answer = arr.get(0) + " " + arr.get(arr.size() - 1);
        return answer;
    }
}