import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int N;
	static Set<Character> capitalChar;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		capitalChar = new HashSet<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String now = br.readLine();
			check(now);

		}
	}

	private static void check(String now) {
		if (ruleOne(now)) {
			return;
		}
		if (ruleTwo(now)) {
			return;
		}
		ruleThree(now);
	}

	private static void ruleThree(String now) {
		System.out.println(now);
	}

	private static boolean ruleTwo(String now) {
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (Character c : now.toCharArray()) {
			if (!capitalChar.contains(Character.toUpperCase(c)) && c != ' ' && !flag) {
				capitalChar.add(Character.toUpperCase(c));
				sb.append("[").append(c).append("]");
				flag = true;
			} else {
				sb.append(c);
			}
		}
		if (flag) {
			System.out.println(sb);
		}
		return flag;
	}

	private static boolean ruleOne(String now) {
		String[] arr = now.split(" ");
		boolean flag = false;
		int idx = -1;
		for (int i=0; i<arr.length; i++) {
			if (!capitalChar.contains(Character.toUpperCase(arr[i].charAt(0)))) {
				capitalChar.add(Character.toUpperCase(arr[i].charAt(0)));
				idx = i;
				flag = true;
				break;
			}
		}
		if (flag) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<arr.length; i++) {
				if (i == idx) {
					for (int j=0; j<arr[i].length(); j++) {
						if (j == 0) {
							sb.append("[").append(arr[i].charAt(j)).append("]");
						} else {
							sb.append(arr[i].charAt(j));
						}
					}
				} else {
					sb.append(arr[i]);
				}
				if (i != arr.length - 1) {
					sb.append(" ");
				}
			}
			System.out.println(sb);
		}
		return flag;
	}
}