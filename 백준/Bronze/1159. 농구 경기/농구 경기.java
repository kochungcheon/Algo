import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String ans = "PREDAJA";

		int[] cnt = new int[26];

		for (int i=0; i<N; i++) {
			cnt[br.readLine().charAt(0)-'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<26; i++) {
			if (cnt[i] >= 5) {
				sb.append((char)(i + 'a'));
			}
		}
		System.out.print(sb.length() != 0 ? sb.toString() : ans);
	}
}