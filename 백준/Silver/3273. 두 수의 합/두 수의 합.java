import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int purpose = Integer.parseInt(br.readLine());
		int ans = 0;
		int s = 0;
		int e = N-1;
		while (s < e) {
			int now = arr[s] + arr[e];
			if (now == purpose) {
				s++;
				e--;
				ans++;
			} else if (now > purpose) {
				e--;
			} else {
				s++;
			}
		}
		System.out.print(ans);
	}
}