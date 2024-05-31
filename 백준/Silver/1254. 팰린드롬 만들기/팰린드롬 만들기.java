import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String str;
	static int e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		e = str.length() - 1;
		int s = 0;
		for (s = 0; s <= e; s++) {
			if (check(s)) {
				break;
			}
		}
		if (s == 0) {
			System.out.println(str.length());
		} else if (s == e) {
			System.out.println(e + str.length());
		} else {
			System.out.println(e + s + 1);
		}
	}

	public static boolean check(int s) {
		for (int i = s; i <= (e + s) / 2; i++) {
			if (str.charAt(i) != str.charAt(e - i + s))
				return false;
		}
		return true;
	}
}