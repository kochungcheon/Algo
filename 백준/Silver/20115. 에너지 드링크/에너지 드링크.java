import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static double[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		Arrays.sort(arr);
		double ans = arr[N-1];
		for (int i=0; i<N-1; i++) {
			ans += arr[i] / 2;
		}
		System.out.println(ans);
	}
}