import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int[] prefix = new int[len * 2 + 1];
        // setting
        for (int i=0; i<len; i++) {
            prefix[i + 1] = elements[i];
            prefix[i + 1 + len] = elements[i];
        }
        
        for (int i=0; i< len * 2; i++) {
            prefix[i + 1] += prefix[i]; 
        }
        
        // check
        // for (int i=0; i<= len * 2; i++) {
        //     System.out.print(prefix[i] + " ");
        // }
        System.out.println();
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<=len; i++) {
            for (int j=i+1; j<=i + len; j++) {
                int a = prefix[j] - prefix[i];
                set.add(a);
            }
        }
        // for (int s : set) {
        //     System.out.print(s + " ");
        // }
        
        int answer = set.size();
        return answer;
    }
}