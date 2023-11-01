import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(Solution(n, arr));
	}

	public static Integer Solution(int N, int[] arr) {
		int ans = 0;
		Arrays.sort(arr);
		// 값, 인덱스
		for (int i=0; i<N; i++) {
			int com = arr[i];
			int s = 0;
			int e = N-1;


			while (s<e) {
				if (s == i) {
					s += 1;
					continue;
				} else if ( e == i) {
					e -= 1;
					continue;
				}
				int tmp_sum = arr[s] + arr[e];
				// 만약 합이
				if (tmp_sum == com) {
					ans++;
					break;
				}
				else if (tmp_sum > com) {
					e -= 1;
				} else {
					s += 1;
				}
			}
		}
		return ans;
	}
}
