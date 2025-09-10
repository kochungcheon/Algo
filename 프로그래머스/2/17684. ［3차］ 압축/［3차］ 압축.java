import java.util.*;

class Solution {
    public int[] solution(String msg) {
       
        int len = msg.length();
        String[] msg_lst = new String[len];
        for (int i=0; i<len; i++){
            msg_lst[i] = msg.substring(i, i+1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        // 초기 값 할당
        int index = 1;
        for (char i='a'; i<= 'z'; i++) {
            map.put(Character.toString(i).toUpperCase(), index++);
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for (int i=0; i<len; i++) {
            String tmp = msg_lst[i];
            for (int j=i; j<len; j++) {
                // 만약 키가 있다면
                if (map.containsKey(tmp)) {
                    // 여유가 있으면 
                    if (j+1 < len){
                        tmp += msg_lst[j+1];
                    } else {
                        System.out.println(tmp);
                        arr.add(map.get(tmp));
                        System.out.println(map.get(tmp));
                        i = j;
                    }
                    // 0
                    //     0 1
                } else {
                    // System.out.println(" i : " + i + " j : " + j + " " + " tmp : " + tmp);
                    arr.add(map.get(tmp.substring(0, tmp.length()-1)));
                    // System.out.println(map.get(tmp.substring(0, tmp.length()-1)));
                    i = j-1;
                    map.put(tmp, index++);
                    break;
                }
                
            }
    
        }
        int[] answer = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }    
        return answer;
    }
}