

import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String he = br.readLine();
		String her = br.readLine();

		int len = he.length() * 2;
		int[] alpha = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

		int[] now = new int[len];
		int[] next = new int[len];

 		for (int i=0; i<len / 2; i++) {
			now[i * 2] = alpha[he.charAt(i) - 'A'];
			now[i * 2 + 1] = alpha[her.charAt(i) - 'A'];
		}

		while (len > 2) {
			for (int i=0; i<len-1; i++) {
				next[i] = (now[i] + now[i+1]) % 10;
			}

			now = next;
			len--;
		}

		System.out.print("" + now[0] + now[1]);
	}
}
