
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String now = br.readLine();
			if (now.equals("0")) break;
			System.out.println(find(now) ? "yes" : "no");
		}
		
	}
	private static boolean find(String now) {
		for (int i = 0; i < now.length() / 2; i++) {
			if (now.charAt(i) != now.charAt(now.length()-i-1)) return false;
		}
		return true;
	}
}
