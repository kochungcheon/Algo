import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    int s = 0;
		int e = 0;

		int ans = 0;
		int life = K;
		int tmp = 0;

		while(e < N && s <= e) {
			if (arr[e] % 2 == 1) {
				life--;
			} else {
				tmp++;
			}
			ans = Math.max(ans, tmp);
			if (life < 0) {
				while (s <= e) {
					if (arr[s++] % 2 == 1) {
						life++;
						break;
					} else {
						tmp--;
					}
				}
			}
			e++;
		}

		System.out.print(ans);
	}
}

