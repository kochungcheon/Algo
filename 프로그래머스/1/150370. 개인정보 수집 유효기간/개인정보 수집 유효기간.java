import java.util.*;
class Solution {
    
	public int[] solution(String today, String[] terms, String[] privacies) {
		// int[] answer = {};
		HashMap<String, Integer> terms_tables = new HashMap<>();
		// 유통 넣는 다
		for (String term : terms) {
			String[] t = term.split(" ");
			terms_tables.put(t[0], Integer.valueOf(t[1]));
		}

		String[] cal = new String[privacies.length];
		for (int i=0; i<privacies.length; i++) {
			String[] privacie = privacies[i].split(" ");
			String com = privacie[1];
            int p = terms_tables.get(com);
            // System.out.println(privacie[0]);
			int plus_day = p * 28 - 1;
            
			String[] day = privacie[0].split("\\.");
            // System.out.println(day.length);
			// for (int ii =0; ii<day.length; ii++) {
            //     System.out.print(day[ii] + " ");
            // }
            // System.out.println();
		// 	// 만료 일 월 년을 세팅한다
			day[2] = String.valueOf(Integer.valueOf(day[2])+plus_day);
            
            while (Integer.valueOf(day[2]) > 28) {
                day[2] = String.valueOf(Integer.valueOf(day[2])-28);
                day[1] = String.valueOf(Integer.valueOf(day[1])+1);
            }
            // System.out.println(day[2]);
			// if (Integer.valueOf(day[2]) > 28) {
			// 	day[1] = String.valueOf(Integer.valueOf(day[1])+1);
			// }
			while (Integer.valueOf(day[1])> 12) {
                day[1] = String.valueOf(Integer.valueOf(day[1])-12);
                day[0] = String.valueOf(Integer.valueOf(day[0])+1);
            }
			// if (Integer.valueOf(day[1]) > 12) {
			// 	day[0] = String.valueOf(Integer.valueOf(day[2])+1);
			// }
			cal[i] = day[0];
            for (int ii=1; ii<=2; ii++) {
                if (day[ii].length() < 2) {
                    cal[i] += "0";
                }
                cal[i] += day[ii];
            }
			// cal[i] = day[0] + day[1] + day[2];
            System.out.println(cal[i]);
		}
		ArrayList<Integer> arr = new ArrayList<>();
		String[] a = today.split("\\.");
		Integer now_int = Integer.parseInt(a[0]+a[1]+a[2]);
        // System.out.println(now_int);
		for (int i=0; i< privacies.length; i++) {
            // System.out.println(Integer.parseInt(cal[i]));
			if (now_int > Integer.parseInt(cal[i])) {
				arr.add(i+1);
			}
		}
		int[] answer = new int[arr.size()];
		for (int i=0; i<arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		
		return answer;
	}
}