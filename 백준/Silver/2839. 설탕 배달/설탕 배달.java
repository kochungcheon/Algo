import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int now = i * 5 + j * 3;
				if (now == N) {
					ans = Integer.min(i + j, ans);
				}
			}
		}
		System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
	}
}