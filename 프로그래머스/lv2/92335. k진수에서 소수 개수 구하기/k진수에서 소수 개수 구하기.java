import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] lst = zinsu(n, k).split("0");
        for (int i =0; i<lst.length; i++){
            if (lst[i].equals("")) continue;
            if (isSosu(Long.parseLong(lst[i]))){
                answer++;
            }
        }
        return answer;
    }
    static String zinsu(int n, int k){
        StringBuilder tmp = new StringBuilder();
        while (n > 0){
            tmp.append(n % k);
            n /= k;
        }
        return tmp.reverse().toString();
    }
    static boolean isSosu(long n){
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i=3; i< Math.sqrt(n)+1; i+=2){
            if (n%i == 0){
                return false;
            }
        }
        return true;
        
    }
}