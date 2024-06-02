import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static long ans;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		ans = 0;
		for (int i=0; i<N-2; i++) {
			for (int j=i+1; j<N-1; j++) {
				int right = checkR(i, j);
				int left = checkL(i, j);
				if (right >= left && left > 0) {
					ans += (right - left + 1);
				}
			}
		}
		System.out.println(ans);
	}

	private static int checkR(int i, int j) {
		int s = j + 1;
		int e = N-1;
		int tmp = -1;
		while (s <= e) {
			int mid = (s + e) / 2;
			int cal = arr[mid] + arr[i] + arr[j];
			if (cal == 0) {
				tmp = mid;
				s = mid + 1;
			} else if (cal < 0) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return tmp;
	}

	private static int checkL(int i, int j) {
		int s = j + 1;
		int e = N-1;
		int tmp = -1;
		while (s <= e) {
			int mid = (s + e) / 2;
			int cal = arr[mid] + arr[i] + arr[j];
			if (cal == 0) {
				tmp = mid;
				e = mid - 1; 
			} else if (cal > 0) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return tmp;
	}
}