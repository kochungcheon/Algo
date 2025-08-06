import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n + 2];
		arr[0] = -1_000_000_010;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[n + 1] = 1_000_000_010;

		int idx = 0;
		int cnt = 0;
		for (int i = 0; i <= n; i++) {
			if (arr[i] > arr[i + 1]) {
				idx = i + 1;
				cnt++;
			}
		}

		if (cnt == 0) {
			System.out.println(n);
		} else if (cnt > 1) {
			System.out.println(0);
		} else {
			if (arr[idx] >= arr[idx - 2] && arr[idx + 1] >= arr[idx - 1]) {
				System.out.println(2);
			} else if (arr[idx] >= arr[idx - 2] || arr[idx + 1] >= arr[idx - 1]) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
