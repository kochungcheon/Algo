import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int n_cnt = One(Integer.toBinaryString(n));
        int compare = n;
        while(true){
            compare++;
            if (One(Integer.toBinaryString(compare)) == n_cnt){
                answer = compare;
                break;
            }
        }
        return answer;
    }
    
    static int One(String bi){
        int cot = 0;
        for (char a : bi.toCharArray()){
            if (a == '1'){
                cot++;
            }
        }
        return cot;
    }
}