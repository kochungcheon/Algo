import java.io.*;

public class Main {
	static String findMax(String target) {
		StringBuilder sb = new StringBuilder();
		int tmp = 0;
		for (char now : target.toCharArray()) {
			if (now == 'K') {
				sb.append(5);
				while (tmp-- > 0) sb.append(0);
				tmp = 0;
			} else {
				tmp++;
			}
		}
		while (tmp-- > 0) sb.append(1);
		return sb.toString();
	}

	static String findMin(String target) {
		StringBuilder sb = new StringBuilder();
		boolean startM = target.charAt(0) == 'M';
		if (startM) sb.append(1);
		
		for (int i = 1; i < target.length(); i++) {
			char now = target.charAt(i);
			char before = target.charAt(i - 1);
			if (now == 'K') {
				sb.append(5);
			} else if (before == 'M') {
				sb.append(0);
			} else {
				sb.append(1);
			}
		}
		if (!startM && target.charAt(0) == 'K') sb.insert(0, 5);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(findMax(str));
		System.out.println(findMin(str));
	}
}
