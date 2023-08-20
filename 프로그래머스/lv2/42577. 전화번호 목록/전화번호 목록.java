import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 모든 전화번호를 map에 저장
        for (String p : phone_book) {
            map.put(p, 1);
        }
        
        // 각 전화번호의 부분 문자열이 map에 존재하는지 확인
        for (String p : phone_book) {
            for (int i = 1; i < p.length(); i++) {
                if (map.containsKey(p.substring(0, i))) {
                    return false;  // 다른 번호의 접두어가 있으므로 false 반환
                }
            }
        }
        
        return true;  // 접두어가 없다면 true 반환
    }
}
