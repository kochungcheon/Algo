

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String one = st.nextToken();
		String two = st.nextToken();
		long ans = 0;
		for (int i=0; i<one.length(); i++) {
			long o = Integer.parseInt(String.valueOf(one.charAt(i)));
			for (int j=0; j<two.length(); j++) {
				ans += o * Integer.parseInt(String.valueOf(two.charAt(j)));
			}
		}
		System.out.print(ans);
	}
}
