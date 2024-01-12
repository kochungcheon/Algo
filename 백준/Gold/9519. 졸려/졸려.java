import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long N;
	static int len;
	static String words, check;
	static List<String> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		words = br.readLine();
		check = words;

		len = check.length();

		arr = new ArrayList<>();
		arr.add(check);

		int cnt = 0;
		StringBuilder tmp;
		while (true) {
			cnt++;
			tmp = new StringBuilder();

			int last = 1;
			for (int i=0; i<len; i++) {

				if (i%2 == 0) {
					tmp.append(words.charAt(i/2));
				}

				else {
					tmp.append(words.charAt(words.length()-last++));
				}
			}

			if (check.contentEquals(tmp)) {
				break;
			} else {
				words = tmp.toString();
				arr.add(words);
			}
		}
		int remain = cnt - (int)(N % cnt);
		if (cnt == 1 || N % cnt == 0) {
			remain = 0;
		}
		System.out.println(arr.get(remain));
		br.close();
	}
}