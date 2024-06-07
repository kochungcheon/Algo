import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			String str = br.readLine().replaceAll(" ", "");
			// 가장 빈번하게 나타나는 것 출력 여러 개일 경우 ? 출력
			int cnt = 0;
			int charCnt = 0;
			char c = '\n';
			int[] chars = new int[26];
			for (int i=0; i<str.length(); i++) {
				chars[str.charAt(i) - 'a']++;
			}

			for (int i=0; i<26; i++) {
				if (chars[i] > cnt) {
					c = (char)(i+'a');
					cnt = chars[i];
					charCnt = 1;
				} else if (chars[i] == cnt) {
					charCnt++;
				}
			}
			System.out.println(charCnt > 1 ? '?' : c);
		}
	}
}