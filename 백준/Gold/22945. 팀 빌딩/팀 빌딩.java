import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int s = 0;
		int e = N-1;
		int ans = 0;
		while (s < e) {
			ans = Math.max(ans, (e - s - 1) * Math.min(arr[s], arr[e]));
			if (arr[s] < arr[e]) s++;
			else e--;
		}
		System.out.print(ans);
	}
}