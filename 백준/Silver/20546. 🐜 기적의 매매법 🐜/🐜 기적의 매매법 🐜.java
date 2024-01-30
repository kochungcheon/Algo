import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// 전량 매수 전량 매도
	// 3일 연속 상승 이며ㅑㄴ 하락 가정
	// 3일 연속 가격 하락 이면 상승 가정
	// 내기 기간은 2021년 1월 1일부터 2021년 1월 14일
	// 승리한다. 1월 14일의 자산은 (현금 + 1월 14일의 주가 × 주식 수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.valueOf(br.readLine());
		int jun = money;
		int jun_stock = 0;

		int sung = money;
		int sung_stock = 0;

		String[] arr =  br.readLine().split(" ");
		int cnt = 100;
		int compare = 0;
		boolean flag = true;
		for (String a : arr) {
			int m = Integer.parseInt(a);
			// 최초는 넘어가~
			if (cnt == 100) {
				cnt = 0;
				compare = m;
			} else {
				// 같으면 초기화
				if (compare == m) {
					cnt = 0;
				}
				// 이전 보다 "작으면"
				else if (compare > m) {
					// cnt 가 + 면 -1 으로 초기화
					if (cnt > 0) {
						cnt = -1;
					} else {
						cnt--;
						// 3회 이상 하락이면 사야됨
						if (cnt < -2) {
							flag = true;
						}
					}
				}

				else {
					// cnt 가 - 면 +1 으로 초기화
					if (cnt < 0) {
						cnt = 1;
					}
					else {
						cnt++;
						if (cnt > 2) {
							flag = false;
						}
					}

				}
			}
			if (jun >= m) {
				jun_stock = jun/m;
				jun %= m;
			}

			// 살 타이밍
			if (flag == true && cnt <= -3) {
				sung_stock += sung/m;
				sung %= m;
			}
			else if (flag == false && cnt >= 3) {
				sung += sung_stock * m;
				sung_stock = 0;
			}
		}
		int last = Integer.parseInt(arr[arr.length-1]);
		int total_jun = jun + jun_stock * last;
		int total_sung = sung + sung_stock * last;

		if (total_jun == total_sung) {
			System.out.println("SAMESAME");
		} else if (total_jun > total_sung) {
			System.out.println("BNP");
		} else {
			System.out.println("TIMING");
		}
	}
}
