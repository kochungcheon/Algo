import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Set<String> set;
	static List<String> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new HashSet<>();
		ans = new ArrayList<>();
		for (int i=0; i<N; i++) {
			set.add(br.readLine());
		}

		for (int i=0; i<M; i++) {
			String now = br.readLine();
			if (set.contains(now)) {
				ans.add(now);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		StringBuilder sb = new StringBuilder();
		for (String s : ans) {
			sb.append(s).append('\n');
		}
		System.out.println(sb);
	}
}