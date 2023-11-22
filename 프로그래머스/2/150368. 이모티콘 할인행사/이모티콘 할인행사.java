import java.util.*;
class Solution {
    static int len;
	// 할인률
	static int[] discount = new int[] {10, 20, 30, 40};
	static ArrayList<Integer> now_dis = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

	// 이모티콘 총 구입액 계산
	static void choose(int cur) {
		if (cur >= len) {
			arr.add(new ArrayList<>(now_dis));
			return;
		}
		int max_value = 0;
		for (int i = 0; i < 4; i++) {
			now_dis.add(discount[i]);
			choose(cur + 1);
			now_dis.remove(now_dis.size() - 1);
		}
	}

	public int[] solution(int[][] users, int[] emoticons) {
		len = emoticons.length;
		// 서비스유저, 총 구입액
		
		choose(0);
		int max_val = 0;
		int max_cnt = 0;

		for (int i=0; i<arr.size(); i++) {
			int now_val = 0;
			int now_cnt = 0;
			for (int[] user : users) {
				int tmp_val = 0;
				for (int j=0; j<len; j++) {
					if (user[0] <= arr.get(i).get(j)) {
						tmp_val += emoticons[j] * (100 - arr.get(i).get(j)) / 100;
					}
				}
				if (tmp_val >= user[1]){
					now_cnt++;
				} else {
					now_val += tmp_val;
				}
			}
			if (max_cnt == now_cnt) {
				max_cnt = now_cnt;
				if (max_val < now_val) {
					max_val = now_val;
				}
			} else if (max_cnt < now_cnt) {
				max_cnt = now_cnt;
				max_val = now_val;
			}
		}
		int[] answer;
		answer = new int[] {max_cnt, max_val};

		return answer;
	}
}