
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[11];
		Arrays.fill(arr, -1);
		int cnt = 0;
		for (int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			int cow = Integer.parseInt(s[0]);
			int line = Integer.parseInt(s[1]);
			if (arr[cow] == -1) {
				arr[cow] = line;
			} else {
				if (arr[cow] != line) {
					cnt++;
					arr[cow] = line;
				}
			}
		}
		br.close();
		System.out.println(cnt);
	}
}