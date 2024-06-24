import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N 등분 하는 데 필요한 시간 출력
		int N = Integer.parseInt(st.nextToken()); // 분
		int m = Integer.parseInt(st.nextToken()); // 맥박 최저, 초기 맥박
		int M = Integer.parseInt(st.nextToken()); // 맥박 최고
		int T = Integer.parseInt(st.nextToken()); // 운동 시 1분당 증가량
		int R = Integer.parseInt(st.nextToken()); // 휴식 시 1분당 감소량

		if (m + T > M) {
			System.out.print(-1);
			return;
		}

		int totalTime = 0;
		int cnt = 0;
		int now = m;

		while (cnt < N) {
			totalTime++;
			if (now + T <= M) {
				now += T;
				cnt++;
			} else {
				now -= R;
				now = Math.max(now, m);
			}
		}
		System.out.print(totalTime);
	}
}
