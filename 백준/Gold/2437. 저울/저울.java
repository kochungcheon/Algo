
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		find();
	}
	static void find() {
		int sum = 0;
		for (int i=0; i<N; i++) {
			if (arr[i] >= sum + 2) break;
			sum += arr[i];
		}
		System.out.print(sum + 1);
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
	}
}
