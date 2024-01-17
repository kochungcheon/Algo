import java.util.HashMap;
class Solution {
		public int solution(String[] friends, String[] gifts) {
			int len = friends.length;
			int answer = 0;

			HashMap<String, Integer> friendsIdx = new HashMap<>();
			for (int i=0; i< len; i++) {
				friendsIdx.put(friends[i], i);
			}

			int[][] giftsMatrix = new int[len][len];
			for (String gift : gifts) {
				String[] tmp = gift.split(" ");
				String giver = tmp[0];
				String receiver = tmp[1];
				int giverIdx = friendsIdx.get(giver);
				int receiverIdx = friendsIdx.get(receiver);
				giftsMatrix[giverIdx][receiverIdx]++;
			}
			// for (int i=0; i<len; i++) {
			//     for (int j=0; j<len; j++) {
			//         System.out.print(giftsMatrix[i][j] +
			//         " ");
			//     } System.out.println();
			// }

			int[] giftPoints = new int[len];
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					if (giftsMatrix[i][j] > 0) {
						giftPoints[i]+= giftsMatrix[i][j];
						giftPoints[j]-= giftsMatrix[i][j];
					}
				}
			}
			// for (int i=0; i<len; i++) {
			//     System.out.println(giftPoints[i]);
			// }

			int[] nextMonth = new int[len];
			// i 를 기준으로 계산
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					if (i==j) continue;
					// 조건 1 서로 주고 받은 기록이 있고 i 가 더 많이 준 경우
					if ((giftsMatrix[i][j] > 0 || giftsMatrix[j][i] > 0) && giftsMatrix[i][j] > giftsMatrix[j][i]) {
						nextMonth[i]++;
					}

					// 조건 2 주고받은 게 없거나 같다면
					else if (giftsMatrix[i][j] == giftsMatrix[j][i]) {
						// i 가 선물 지수가 높아야 받을 수 있다
						if (giftPoints[i] > giftPoints[j]) {
							nextMonth[i]++;
						}
					}
				}
			}

			for (int i=0; i<len; i++) {
				answer = Math.max(answer, nextMonth[i]);
			}
			return answer;
		}
	}