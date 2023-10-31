import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[0] = 1;
		int[] num = new int[20];
		num[0] = 1;
		for (int i=1; i<20; i++) {
			num[i] = num[i-1] * 2;
		}

		for (int i=0; i<20; i++) {
			for (int j=num[i]; j<=n; j++) {
				int a = dp[j] + dp[j-num[i]];
				dp[j] = (dp[j] + dp[j-num[i]]) % 1000000000;
			}
		}
		System.out.println(dp[n]);
	}
}