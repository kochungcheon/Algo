import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int G = Integer.parseInt(st.nextToken());
		List<Long> ans = new ArrayList<>();

		long s = 1;
		long e = 1;
		while ( G >= e) {
			long now = e*e - s*s;
			if (now == G) {
				ans.add(e++);
				s++;
			} else if (now > G) {
				s++;
			} else {
				e++;
			}
		}
		
		if (ans.isEmpty()) {
			System.out.print(-1);
		} else {
			for (long a : ans) {
				System.out.println(a);
			}
		}
	}
}