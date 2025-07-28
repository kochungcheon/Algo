import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ans = 0;
		
		int s = 0;
		int e = N - 1;
		while (s < e) {
			ans = cal(s, e);
			if (arr[s] < arr[e]) s++;
			else e--;
		}
        System.out.print(ans);
	}
	static int cal(int s, int e) {
		return Math.max(ans, (e - s - 1) * Math.min(arr[s], arr[e]));
	}
}