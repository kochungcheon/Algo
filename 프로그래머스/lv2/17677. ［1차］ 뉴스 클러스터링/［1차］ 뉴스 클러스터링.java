import java.util.*;
import java.lang.*;
class Solution {
    static boolean isValid(char c){
        return c >= 'a' && c <= 'z';
    }
    public int solution(String str1, String str2) {
        
        String[] str1List = str1.split("");
        String[] str2List = str2.split("");
        
        List<String> str1union = new ArrayList<>();
        List<String> str2union = new ArrayList<>();
     
        
        int index = 0;
        for (int i=0; i<str1List.length-1; i++){
            char fst = str1List[i].toLowerCase().charAt(0);
            char snd = str1List[i+1].toLowerCase().charAt(0);
            if (isValid(fst) && isValid(snd)){
                String tmp = fst + "" + snd;
                str1union.add(tmp);
            }
        }
        
        
        for (int i=0; i<str2List.length-1; i++){
            char fst = str2List[i].toLowerCase().charAt(0);
            char snd = str2List[i+1].toLowerCase().charAt(0);
            if (isValid(fst) && isValid(snd)){
                str2union.add(fst + "" + snd);
            }
        }
        
        int inte = 0;
        for (String s1 : str1union){
            if (str2union.remove(s1)){
                inte++;
            }   
        }
        System.out.println(inte);
        
        int union = str1union.size() + str2union.size();
        if (union == 0){
            return 65536;
        }
        double tmp = (double) inte / union;
        System.out.println(tmp);
        // int answer = (int)(tmp * 65536);
        

        return (int)(tmp * 65536);
    }
}
//자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.

//  집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의

// 문자열 "FRANCE"와 "FRENCH"가 주어졌을 때, 이를 두 글자씩 끊어서 다중집합을 만들 수 있다. 각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}가 되며, 교집합은 {FR, NC}, 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}가 되므로,

// 특수문자가 들어있는 경우는 글자 쌍을 버린다 

// 대소문자 차이 무시