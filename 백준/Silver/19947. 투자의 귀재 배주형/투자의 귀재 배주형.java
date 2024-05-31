import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static double H;
	static int Y;
	static double A = 1.05;
	static double B = 1.2;
	static double C = 1.35;
	static double[] dp = new double[11];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Double.parseDouble(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		Arrays.fill(dp, H);
		for (int i=1; i<=Y; i++) {
			dp[i] = (int)(dp[i-1] * A);
			if (i >= 3) {
				dp[i] = Math.max(dp[i], (int)(dp[i-3] * B));
			}
			if (i >= 5) {
				dp[i] = Math.max(dp[i], (int)(dp[i-5] * C));
			}
		}

		System.out.print((int)dp[Y]);

	}
}