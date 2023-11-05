import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int j = 0; j < T; j++) {
			int N = sc.nextInt();
			sc.nextLine();
			String[] arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextLine();
			}
			System.out.println(Solution(N, arr));
		}
	}
	static HashSet<Integer> dp;
	static HashSet<Integer> tmp_dp;
	static String Solution(int N, String[] arr) {
		dp = new HashSet<>();
		dp.add(1);
		for (int i = 0; i < N; i++) {
			String[] new_arr = arr[i].split(" ");

			tmp_dp = new HashSet<>();
			cal(new_arr[0], new_arr[1]);
			cal(new_arr[2], new_arr[3]);
			dp = tmp_dp;

		}

		int ans = 0;
		for (int a : dp) {
			if (a == 0) {
				ans++;
				break;
			}
		}
		return ans > 0 ? "LUCKY" : "UNLUCKY";
	}

	static void cal(String com, String a) {
		for (int tmp : dp) {
			if (com.equals("+")) {
				tmp_dp.add((tmp + Integer.parseInt(a)) % 7);
			} else if (com.equals("*")) {
				tmp_dp.add((tmp * Integer.parseInt(a)) % 7);
			}
		}
	}
}
