import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] H = new int[N];
		int[] P = new int[N];
		int[] S = new int[N];

		for (int i=0; i<N; i++) {
			String now = br.readLine();
			if (now.equals("H")) H[i] += 1;
			else if (now.equals("P")) P[i] += 1;
			else if (now.equals("S")) S[i] += 1;
		}

		for (int i=0; i<N-1; i++) {
			H[i+1] += H[i];
			P[i+1] += P[i];
			S[i+1] += S[i];
		}

		int ans = Math.max(Math.max(H[N-1], P[N-1]), S[N-1]);

		for (int i=0; i<N-1; i++) {
			ans = Math.max(ans, Math.max(H[i] + P[N-1] - P[i], H[i] + S[N-1] - S[i]));
			ans = Math.max(ans, Math.max(P[i] + H[N-1] - H[i], P[i] + S[N-1] - S[i]));
			ans = Math.max(ans, Math.max(S[i] + P[N-1] - P[i], S[i] + H[N-1] - H[i]));
		}
		System.out.print(ans);
	}
}
