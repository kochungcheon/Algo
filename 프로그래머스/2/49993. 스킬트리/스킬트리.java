import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<skill.length(); i++) {
            map.put(String.valueOf(skill.charAt(i)), i);
        }
        for (String skill_tree : skill_trees) {
            // 해시에 값이 있으면 비교나 넣고 없으면 넘어가~ 
            boolean flag = true;
              
            int tmp = -1;
            for (int i=0; i<skill_tree.length(); i++) {
                String now = String.valueOf(skill_tree.charAt(i));
                if (map.containsKey(now)) {
                    if (tmp == -1 && map.get(now) == 0) {
                        tmp = 0;
                    }
                    // 초기값이 들어갔고 && 순서가 맞을 때
                    else if (tmp >= 0 && map.get(now) - tmp == 1) {
                        tmp = map.get(now);
                    } 
                    
                    else {
                        flag = false;
                        break;
                    }
                    // System.out.println(now + " " + tmp);
                    // if (flag) {
                    //     System.out.println("true");
                    // } else {
                    //     System.out.println("false");
                    // }
                } 
                
            }
            if (flag) {
                answer++;
            }
            System.out.println();
            
        }
        return answer;
    }
    
}