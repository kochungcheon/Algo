import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String ac = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(",");
			if (len == 0) {
				if (ac.contains("D")) {
					System.out.println("error");
				}
				else {
					System.out.println("[]");
				}
				continue;
			}
			s[0] = s[0].substring(1);
			s[s.length-1] = s[s.length-1].substring(0, s[s.length-1].length() - 1);

			int[] arr = new int[s.length];
			int dCnt = 0;
			for (int i=0; i< ac.length(); i++) {
				if (ac.charAt(i) == 'D') {
					dCnt++;
				}
			}

			if (dCnt > len) {
				System.out.println("error");
				continue;
			} else if (dCnt == len) {
				System.out.println("[]");
				continue;
			}


			for (int i = 0; i < s.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			boolean flag = false;
			int sIdx = 0;
			int eIdx = len-1;
			for (int i=0; i<ac.length(); i++) {
				char c = ac.charAt(i);
				if (c == 'R') {
					flag ^= true;
				} else {
					// 뒷 방향
					if (flag) {
						eIdx--;
					}
					// 정방향
					else {
						sIdx++;
					}
				}
			}
			if ((len == 0 && ac.contains("D")) || sIdx > eIdx) {
				System.out.println("error");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if (!flag) {
					for (int i=sIdx; i<=eIdx; i++) {
						if (i == eIdx) {
							sb.append(arr[i]);
						} else {
							sb.append(arr[i]).append(",");
						}

					}
				} else {
					for (int i=eIdx; i>=sIdx; i--) {
						if (i == sIdx) {
							sb.append(arr[i]);
						} else {
							sb.append(arr[i]).append(",");
						}
					}
				}
				sb.append("]");
				System.out.println(sb);
			}

		}
	}
}