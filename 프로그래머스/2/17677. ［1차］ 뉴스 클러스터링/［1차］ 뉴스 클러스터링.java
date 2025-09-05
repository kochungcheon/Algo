import java.util.*;
import java.io.*;

class Solution {
    static int MOD = 65536;
    public int solution(String str1, String str2) {
        int answer = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = Character.toLowerCase(str1.charAt(i));
            sb1.append(c1);
        }
        for (int i = 0; i < str2.length(); i++) {
            char c2 = Character.toLowerCase(str2.charAt(i));
            sb2.append(c2);
        }
        
        str1 = sb1.toString();
        str2 = sb2.toString();
        
        List<String> group1 = new ArrayList<String>();
        List<String> group2 = new ArrayList<String>();
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        // 65 122
        for (int i=0; i<len1-1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            // System.out.println(str1.substring(i, i+2));
            
            if (isAlpha(a) && isAlpha(b)) {
                group1.add(str1.substring(i, i+2));
            }
        }
        
        for (int i=0; i<len2-1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);
            
            if (isAlpha(a) && isAlpha(b)) {
                group2.add(str2.substring(i, i+2));
            }
        }

        group1.sort(Comparator.naturalOrder());
        group2.sort(Comparator.naturalOrder());
        
        System.out.println(group1);
        System.out.println(group2);
        if (group1.isEmpty() && group2.isEmpty()) return MOD;
        
        
        Set<String> set = new HashSet<>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        for (String s : group1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
            set.add(s);
        }
        
        
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for (String s : group2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
            set.add(s);
        }
        
        int total = 0;
        int j = 0;
        for (String item : set) {
            int cnt1 = map1.getOrDefault(item, 0);
            int cnt2 = map2.getOrDefault(item, 0);
            System.out.println(cnt1 + " " + cnt2);
            System.out.println(item);
            total += Math.max(cnt1, cnt2);
            j += Math.min(cnt1, cnt2);
        }
        
        float tmp = (float) j / (float) total;
        System.out.println((int)(tmp * MOD));
        
        
        
        
        return (int)(tmp * MOD);
    }
    static boolean isAlpha(char c) {
        return ((int) c >= 97 && (int) c <= 122) || (65 <= (int) c && 90 >= (int) c);
    }
}