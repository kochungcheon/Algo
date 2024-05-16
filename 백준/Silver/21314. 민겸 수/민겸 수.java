import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String findMax(String target) {
		StringBuilder sb = new StringBuilder();
		int tmp = 0;
		for (int i=0; i<target.length(); i++) {
			char now = target.charAt(i);
			if (now == 'K' && tmp == 0) {
				sb.append(5);
			} else {
				if (now == 'K') {
					sb.append(5);
					for (int j=0; j<tmp; j++) {
						sb.append(0);
					}
					tmp = 0;
				} else {
					tmp ++;
				}
			}
		}
		if (tmp != 0) {
			for (int j=0; j<tmp; j++) {
				sb.append(1);
			}
		}
		return sb.toString();
	}
	static String findMin(String target) {
		// K는 5
		// 뒤에 M 이 오면 0 맨 앞 M 은 1
		StringBuilder sb = new StringBuilder();
		char before = '\n';
		for (int i=0; i<target.length(); i++) {
			char now = target.charAt(i);
			if (before == '\n') {
				if (now == 'M') {
					sb.append(1);
				} else {
					sb.append(5);
				}
			}
			else {
				if (now == 'K') {
					sb.append(5);
				}
				else {
					if (before == 'M') {
						sb.append(0);
					}
					else {
						sb.append(1);
					}
				}
			}
			before = now;
		}
		return sb.toString();
	}
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		System.out.println(findMax(str));
		System.out.println(findMin(str));
	}
}