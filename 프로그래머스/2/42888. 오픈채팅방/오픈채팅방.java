import java.util.*;
class Solution {
	public String[] solution(String[] records) {
		HashMap<String, String> map = new HashMap<>();
        int cnt = 0;
		for (String record : records) {
			String[] re = record.split(" ");
			if (re[0].equals("Enter")) {
				map.put(re[1], re[2]);
                cnt++;
			} else if (re[0].equals("Change")) {
                map.put(re[1], re[2]);
            } else if (re[0].equals("Leave")) {
                cnt++;
            }
		}
        
        String[] answer = new String[cnt];
        int index = 0;
        for (String record : records) {
			String[] re = record.split(" ");
			String now = "";
            if (re[0].equals("Enter")) {
                now = map.get(re[1])+"님이 들어왔습니다.";
                answer[index++] = now;
			} else if (re[0].equals("Leave")) {
                now = map.get(re[1])+"님이 나갔습니다.";
                answer[index++] = now;
            }
            
		}
		
		return answer;
	}
}